package io.nftips.kunpeng.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.nftips.kunpeng.orm.entity.NFTMintStatisticsEntity;
import io.nftips.kunpeng.orm.entity.NftInfoEntity;
import io.nftips.kunpeng.orm.mapper.NftInfoMapper;
import io.nftips.kunpeng.orm.service.NftInfoService;
import io.nftips.kunpeng.service.NFTBlockChainInfoService;
import io.nftips.kunpeng.vo.NFTInfoSearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

        return searchByNameOrId(nftInfoEntity.getCategoryId());
    }

    /**
     * 通过NFT类别名称或者标识查询
     *
     * @param categoryId 名称或者标识
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByNameOrId(String categoryId) {
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
        BeanUtil.copyProperties(nftInfoEntity, baseInfo);
        baseInfo.setIssueCount(mintNftCount);
        baseInfo.setIssueStep("mint_nft");
        if ("issue_denom".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender(nftInfoEntity.getSender());
            baseInfo.setIssueStep("issue_denom");
        } else if ("transfer_denom".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender(nftInfoEntity.getRecipient());
            baseInfo.setIssueStep("transfer_denom");
        } else if ("mint_nft".equals(nftInfoEntity.getTradingType())) {
            baseInfo.setSender("");
        }
        nftInfoSearchVo.setBaseInfo(baseInfo);

        if (isMintNft) {
            NFTMintStatisticsEntity statisticsEntity = nftInfoMapper.statisticsBaseInfo(nftInfoEntity.getCategoryId());
            if (statisticsEntity == null) {
                BeanUtil.copyProperties(statisticsEntity, baseInfo);
            }
            Long realTradeCount = nftInfoMapper.statisticsRealTradeCount(nftInfoEntity.getCategoryId());
            baseInfo.setRealTradeCount(realTradeCount);
            if (realTradeCount == null) {
                baseInfo.setRealTradeCount(0L);
            }
        }
        return nftInfoSearchVo;
    }
}
