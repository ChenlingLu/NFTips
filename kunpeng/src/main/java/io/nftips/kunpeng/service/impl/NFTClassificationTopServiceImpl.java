package io.nftips.kunpeng.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.nftips.kunpeng.orm.entity.NftInfoEntity;
import io.nftips.kunpeng.orm.entity.NftTopInfoEntity;
import io.nftips.kunpeng.orm.mapper.NftInfoMapper;
import io.nftips.kunpeng.orm.mapper.NftTradingInfoMapper;
import io.nftips.kunpeng.orm.service.NftInfoService;
import io.nftips.kunpeng.service.NFTClassificationTopService;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.NftTopInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NFT 类别TOP N服务
 *
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 上午10:07
 **/
@Service
public class NFTClassificationTopServiceImpl implements NFTClassificationTopService {
    private static final Logger logger = LoggerFactory.getLogger(NFTClassificationTopServiceImpl.class);

    @Resource
    private NftTradingInfoMapper nftTradingInfoMapper;
    @Resource
    private NftInfoMapper nftInfoMapper;
    @Resource
    private NftInfoService nftInfoService;

    /**
     * TOP 10
     *
     * @return
     */
    @Override
    public R top10() {
        /*List<NftTopInfoEntity> topInfos = nftTradingInfoMapper.selectTopN(10);
        if (CollectionUtils.isEmpty(topInfos)) {
            return R.ok();
        }

        for (NftTopInfoEntity entity : topInfos) {
            String catId = entity.getCategoryId();
            try {
                QueryWrapper<NftInfoEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("category_id", catId);
                queryWrapper.eq("trading_type", "mint_nft");
                queryWrapper.last("limit 1");

                NftInfoEntity nftInfoEntity = nftInfoMapper.selectOne(queryWrapper);
                if (nftInfoEntity == null) {
                    queryWrapper.clear();
                    queryWrapper.eq("category_id", catId);
                    queryWrapper.last("limit 1");
                    nftInfoEntity = nftInfoMapper.selectOne(queryWrapper);
                    if (nftInfoEntity != null) {
                        // 不是发行者
                        nftInfoEntity.setSender("");
                    }
                }
                if (nftInfoEntity != null) {
                    BeanUtil.copyProperties(nftInfoEntity, entity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<NftTopInfoVo> top10 = topInfos.stream().filter(x -> x.getCategoryName() != null)
                .map(entity -> BeanUtil.copyProperties(entity, NftTopInfoVo.class))
                .collect(Collectors.toList());*/
        List<String> explain = nftTradingInfoMapper.selectTopN_Explain(10);
        return R.ok(explain);
    }
}
