package io.nftips.kunpeng.service;

import io.nftips.kunpeng.vo.DataAnalyVo;

public interface DataAnalyService {
    /**
     * 统计交易数据
     *
     * @param passedDay  过去多少天
     * @param categoryId NFT分类标识
     *
     * @return
     */
    DataAnalyVo statisticTradeInfo(Integer passedDay, String categoryId);

}
