package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.orm.mapper.DataAnalyMapper;
import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.util.DataUtils;
import io.nftips.kunpeng.vo.AverageRevenue;
import io.nftips.kunpeng.vo.DataAnalyVo;
import io.nftips.kunpeng.vo.PriceHistory;
import io.nftips.kunpeng.vo.TradingNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataAnalyServiceImpl implements DataAnalyService {


    @Resource
    private DataAnalyMapper dataAnalyMapper;

    /**
     * 统计交易数据
     *
     * @param passedDay  过去多少天
     * @param categoryId NFT分类标识
     * @return
     */
    @Override
    public DataAnalyVo statisticTradeInfo(Integer passedDay, String categoryId, String nftName) {

        // 当前时间
        String currentTimeString = DataUtils.getCurrentTimeString();
        //近两天
        String pastDate = DataUtils.getPastDate(passedDay);

        String oldPastDate = DataUtils.getPastDate(passedDay * 2);

        // 查询categoryId 对应passedDay的历史价格信息

        List<PriceHistory> priceHistoryList = dataAnalyMapper.selectPriceHistory(categoryId, nftName, pastDate);

        // 查询categoryId 对应passedDay的收益情况
        List<AverageRevenue> averageRevenueList = dataAnalyMapper.selectAverageRevenueList(categoryId, nftName, pastDate);
        //总收益
        Double totalRevenue = dataAnalyMapper.selectTotalRevenue(categoryId, nftName, pastDate);
        //对比passedDay之前
        Double oldTotalRevenue = dataAnalyMapper.selectTotalRevenue(categoryId, nftName, oldPastDate);


        // passedDay内交易次数
        List<TradingNumber> tradingNumberList = dataAnalyMapper.selectTradingNumberList(categoryId, nftName, passedDay);
        //总次数
        Integer totalTradingNum = dataAnalyMapper.selectTotalTradingNum(categoryId, nftName, pastDate);
        //对比passedDay之前
        Integer oldTotalTradingNum = dataAnalyMapper.selectTotalTradingNum(categoryId, nftName, oldPastDate);


        //历史交易次数

        return null;
    }
}
