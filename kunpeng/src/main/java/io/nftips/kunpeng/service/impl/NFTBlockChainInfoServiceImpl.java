package io.nftips.kunpeng.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.nftips.kunpeng.orm.entity.HoldingPeriodEntity;
import io.nftips.kunpeng.orm.entity.NFTMintStatisticsEntity;
import io.nftips.kunpeng.orm.entity.NftInfoEntity;
import io.nftips.kunpeng.orm.entity.NftProfitEntity;
import io.nftips.kunpeng.orm.mapper.NftInfoMapper;
import io.nftips.kunpeng.orm.mapper.NftTradingInfoMapper;
import io.nftips.kunpeng.orm.service.NftInfoService;
import io.nftips.kunpeng.service.NFTBlockChainInfoService;
import io.nftips.kunpeng.vo.NFTInfoSearchVo;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午2:02
 **/
@Service
public class NFTBlockChainInfoServiceImpl implements NFTBlockChainInfoService {
    private static final Logger logger = LoggerFactory.getLogger(NFTBlockChainInfoServiceImpl.class);

    @Resource
    private NftInfoService nftInfoService;

    @Resource
    private NftInfoMapper nftInfoMapper;

    @Resource
    private NftTradingInfoMapper nftTradingInfoMapper;

    /**
     * 根据图像Hash查询数字藏品
     *
     * @param imgHash 图像Hash
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByImgHash(String imgHash) {

        // 查询NFT基本信息
        NftInfoEntity nftInfoEntity = nftInfoService.lambdaQuery().select(NftInfoEntity::getCategoryId)
                .eq(NftInfoEntity::getImgHash, imgHash)
                .last("limit 1").one();
        if (nftInfoEntity == null) {
            return null;
        }

        return searchByCategory(nftInfoEntity.getCategoryId());
    }

    /**
     * 通过NFT类别名称或者标识查询
     *
     * @param categoryId 名称或者标识
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByCategory(String categoryId) {
        if (StrUtil.isBlank(categoryId)) {
            return null;
        }
        NftInfoEntity nftInfoEntity = nftInfoService.lambdaQuery().select()
                .eq(NftInfoEntity::getCategoryId, categoryId)
                .eq(NftInfoEntity::getTradingType, "issue_denom")
                .orderByAsc(NftInfoEntity::getOccurTime)
                .last("limit 1").one();
        // 是否发行NFT
        boolean isMintNft = true;
        if (nftInfoEntity == null) {
            nftInfoEntity = nftInfoService.lambdaQuery().select()
                    .eq(NftInfoEntity::getCategoryId, categoryId)
                    .eq(NftInfoEntity::getTradingType, "transfer_denom")
                    .orderByAsc(NftInfoEntity::getOccurTime)
                    .last("limit 1").one();
            isMintNft = false;
        }
        if (nftInfoEntity == null) {
            nftInfoEntity = nftInfoService.lambdaQuery().select()
                    .eq(NftInfoEntity::getCategoryId, categoryId)
                    .eq(NftInfoEntity::getTradingType, "issue_denom")
                    .orderByAsc(NftInfoEntity::getOccurTime)
                    .last("limit 1").one();
            isMintNft = false;
        }

        if (nftInfoEntity == null) {
            logger.warn("数据异常，未查到创建类别、转让类别、发行相关的数据，仅仅有转让");
            nftInfoEntity = nftInfoService.lambdaQuery().select()
                    .eq(NftInfoEntity::getCategoryId, categoryId)
                    .eq(NftInfoEntity::getTradingType, "mint_nft")
                    .orderByAsc(NftInfoEntity::getOccurTime)
                    .last("limit 1").one();
            isMintNft = true;
        }
        if (nftInfoEntity == null) {
            return null;
        }

        Long mintNftCount = 0L;
        NFTInfoSearchVo nftInfoSearchVo = new NFTInfoSearchVo();
        NFTInfoSearchVo.BaseInfo baseInfo = new NFTInfoSearchVo.BaseInfo();
        nftInfoSearchVo.setBaseInfo(baseInfo);
        BeanUtil.copyProperties(nftInfoEntity, baseInfo);
        baseInfo.setIssueCount(mintNftCount);
        baseInfo.setIssueStep("mint_nft");
        baseInfo.setHoldingHuman(0L);
        if ("issue_denom".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender(nftInfoEntity.getSender());
            baseInfo.setIssueStep("issue_denom");
        } else if ("transfer_denom".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender(nftInfoEntity.getRecipient());
            baseInfo.setIssueStep("transfer_denom");
        } else if ("mint_nft".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender("");
        }

        if (isMintNft) {
            NFTMintStatisticsEntity statisticsEntity = nftInfoMapper.statisticsBaseInfo(categoryId);
            if (statisticsEntity != null) {
                BeanUtil.copyProperties(statisticsEntity, baseInfo);
            }
            Long realTradeCount = nftInfoMapper.statisticsRealTradeCount(categoryId);
            baseInfo.setRealTradeCount(realTradeCount);
            if (realTradeCount == null) {
                baseInfo.setRealTradeCount(0L);
            }
        }
        // 填充交易摘要
        NFTInfoSearchVo.TradeSummary tradeSummary = new NFTInfoSearchVo.TradeSummary();
        nftInfoSearchVo.setTradeSummary(tradeSummary);
        tradeSummary.setAvgValue(0.0D);
        tradeSummary.setCategoryId(categoryId);
        tradeSummary.setLastTransferTime("");
        tradeSummary.setLastTransferValue(0.0D);
        tradeSummary.setTotalProfit(0.0D);
        if (isMintNft) {
            NftProfitEntity nftProfit = nftTradingInfoMapper.statisticsProfit(categoryId);
            if (nftProfit != null) {
                BeanUtil.copyProperties(nftProfit, tradeSummary);
            }
        }

        // 填充持有时间
        NFTInfoSearchVo.HoldingPeriod holdingPeriod = new NFTInfoSearchVo.HoldingPeriod();
        nftInfoSearchVo.setHoldingPeriod(holdingPeriod);
        Map<String, Object> larger = new HashMap<>(2);
        larger.put("radio", "0%");
        larger.put("tip", "<365d");

        Map<String, Object> middle = new HashMap<>(2);
        middle.put("radio", "0%");
        middle.put("tip", "<365d");

        Map<String, Object> small = new HashMap<>(2);
        small.put("radio", "0%");
        small.put("tip", "<365d");

        holdingPeriod.setLager(larger);
        holdingPeriod.setMiddle(middle);
        holdingPeriod.setSmall(small);

        if (isMintNft) {
            HoldingPeriodEntity holdingPeriodEntity = nftInfoMapper.statisticsHoldingPeriod(categoryId);
            if (holdingPeriodEntity != null) {
                larger.put("radio", holdingPeriodEntity.getLagerRadio());
                middle.put("radio", holdingPeriodEntity.getMiddleRadio());
                small.put("radio", holdingPeriodEntity.getSmallRadio());
            }
        }

        return nftInfoSearchVo;
    }

    /**
     * 模糊搜索
     *
     * @param nameOrId NFT分类标识或者分类名称
     *
     * @return
     */
    @Override
    public Map<String, Object> fuzzySearch(String nameOrId) {
        List<NftInfoEntity> list = nftInfoService.lambdaQuery()
                .select(NftInfoEntity::getCategoryId, NftInfoEntity::getCategoryName)
                .like(NftInfoEntity::getCategoryId, nameOrId)
                .or().like(NftInfoEntity::getCategoryName, nameOrId)
                .or().like(NftInfoEntity::getNtfName, nameOrId)
                .groupBy(NftInfoEntity::getCategoryId)
                .groupBy(NftInfoEntity::getCategoryName)
                .list();

        Integer count = 0;
        if (list != null) {
            count = list.size();
        }
        Map<String, Object> maps = new HashMap<>(2);
        maps.put("list", list);
        maps.put("count", count);
        return maps;
    }
}
