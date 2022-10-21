package io.nftips.kunpeng.service.impl;

import cn.hutool.core.bean.BeanUtil;
import io.nftips.kunpeng.orm.entity.NftTopInfoEntity;
import io.nftips.kunpeng.orm.mapper.NftTradingInfoMapper;
import io.nftips.kunpeng.service.NFTClassificationTopService;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.NftTopInfoVo;
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
    @Resource
    private NftTradingInfoMapper nftTradingInfoMapper;

    /**
     * TOP 10
     *
     * @return
     */
    @Override
    public R top10() {
        List<NftTopInfoEntity> topInfos = nftTradingInfoMapper.selectTopN(10);
        if (!CollectionUtils.isEmpty(topInfos)) {
            List<NftTopInfoVo> top10 = topInfos.stream()
                    .map(entity -> BeanUtil.copyProperties(entity, NftTopInfoVo.class))
                    .collect(Collectors.toList());
            return R.ok(top10);
        }
        return R.ok();
    }
}
