package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.service.NFTBlockChainInfoService;
import io.nftips.kunpeng.vo.NFTInfoSearchVo;
import org.springframework.stereotype.Service;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午2:02
 **/
@Service
public class NFTBlockChainInfoServiceImpl implements NFTBlockChainInfoService {
    /**
     * 根据图像Hash查询数字藏品
     *
     * @param imgHash 图像Hash
     *
     * @return
     */
    @Override
    public NFTInfoSearchVo searchByImgHash(String imgHash) {
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
