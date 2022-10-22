package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.orm.entity.NftInfoEntity;
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
    /**
     * 根据图像Hash查询数字藏品
     *
     * @param imgHash 图像Hash
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByImgHash(String imgHash) {
        nftInfoService.lambdaQuery().select()
                .eq(NftInfoEntity::getCategoryName,imgHash)
                .last("limit 1").one();
        return null;
    }

    /**
     * 通过NFT类别名称或者标识查询
     *
     * @param nameOrId 名称或者标识
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByNameOrId(String nameOrId) {
        return null;
    }
}
