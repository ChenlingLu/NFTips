package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.vo.DataAnalyVo;
import org.springframework.stereotype.Service;

@Service
public class DataAnalyServiceImpl implements DataAnalyService {


    /**
     * 统计交易数据
     *
     * @param passedDay  过去多少天
     * @param categoryId NFT分类标识
     *
     * @return
     */
    @Override
    public DataAnalyVo statisticTradeInfo(Integer passedDay, String categoryId) {
        return null;
    }
}
