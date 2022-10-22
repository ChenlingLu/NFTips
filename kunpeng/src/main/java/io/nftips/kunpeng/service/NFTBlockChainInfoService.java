package io.nftips.kunpeng.service;

import io.nftips.kunpeng.vo.NFTInfoSearchVo;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午2:00
 **/
public interface NFTBlockChainInfoService {

    /**
     * 根据图像Hash查询数字藏品
     *
     * @param imgHash 图像Hash
     *
     * @return
     */
    NFTInfoSearchVo searchByImgHash(String imgHash);

    /**
     * 通过NFT类别名称或者标识查询
     *
     * @param nameOrId 名称或者标识
     *
     * @return
     */
    NFTInfoSearchVo searchByNameOrId(String nameOrId);
}
