package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.orm.mapper.DataAnalyMapper;
import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.util.DataUtils;
import io.nftips.kunpeng.vo.AverageRevenue;
import io.nftips.kunpeng.vo.DataAnalyVo;
import io.nftips.kunpeng.vo.PriceHistory;
import io.nftips.kunpeng.vo.TradingNumber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public DataAnalyVo statisticTradeInfo(Integer passedDay, String categoryId) {

        DataAnalyVo dataAnalyVo = new DataAnalyVo();
        dataAnalyVo.setCategoryId(categoryId);
        //当前时间
        String currentDay = DataUtils.getCurrentTimeString();
        //过去天数
        String pastDate = DataUtils.getPastDate(passedDay);
        //过去的过去的天数
        String oldPastDate = DataUtils.getPastDate(passedDay * 2);

        // 查询categoryId 对应passedDay的历史价格信息
        List<PriceHistory> priceHistoryList = dataAnalyMapper.selectPriceHistory(categoryId, pastDate, currentDay);
        dataAnalyVo.setPriceHistory(priceHistoryList);
        // 查询categoryId 对应passedDay的收益情况
        // 过去时间到当前时间段内收益情况
        List<AverageRevenue> averageRevenueList = dataAnalyMapper.selectAverageRevenueList(categoryId, pastDate, currentDay);
        //总收益
        Double totalRevenue = dataAnalyMapper.selectTotalRevenue(categoryId, pastDate, currentDay);
        //过去时间到过去时间的对比 比如pastDate=2022-10-12 00：00：00
        //则此处计算为 pastDate: 2022-10-10 00：00：00 --oldPastDate 2022-10-12 00：00：00
        Double oldTotalRevenue = dataAnalyMapper.selectTotalRevenue(categoryId, oldPastDate, pastDate);
        dataAnalyVo.setAverageRevenue(averageRevenueList);
        dataAnalyVo.setTotalRevenue(totalRevenue);

        // 计算收益差
        calculationAverageRevenue(dataAnalyVo, totalRevenue, oldTotalRevenue);

        // passedDay内交易次数
        List<TradingNumber> tradingNumberList = dataAnalyMapper.selectTradingNumberList(categoryId, pastDate, currentDay);
        //总次数
        Integer totalTradingNum = dataAnalyMapper.selectTotalTradingNum(categoryId, pastDate, currentDay);
        //对比passedDay之前
        Integer oldTotalTradingNum = dataAnalyMapper.selectTotalTradingNum(categoryId, oldPastDate, pastDate);
        //计算交易次数差
        calculationTradingNum(dataAnalyVo, totalTradingNum, oldTotalTradingNum);
        dataAnalyVo.setTotalTradingNum(totalTradingNum);
        dataAnalyVo.setTradingNumber(tradingNumberList);

        //历史交易次数

        return null;
    }

    private void calculationTradingNum(DataAnalyVo dataAnalyVo, Integer totalTradingNum, Integer oldTotalTradingNum) {
        if (totalTradingNum == null) {
            totalTradingNum = 0;
        }
        if (oldTotalTradingNum == null) {
            oldTotalTradingNum = 0;
        }
        String beforeTradingNum = null;
        //计算收益差
        if (totalTradingNum - oldTotalTradingNum >= 0) {
            beforeTradingNum = "+" + (totalTradingNum - oldTotalTradingNum);
        } else {
            beforeTradingNum = "-" + (oldTotalTradingNum - totalTradingNum);
        }
        dataAnalyVo.setBeforeTradingNum(beforeTradingNum);
    }

    private void calculationAverageRevenue(DataAnalyVo dataAnalyVo, Double totalRevenue, Double oldTotalRevenue) {
        if (totalRevenue == null) {
            totalRevenue = 0D;
        }
        if (oldTotalRevenue == null) {
            oldTotalRevenue = 0D;
        }
        String beforeRevenue = null;
        //计算收益差
        if (totalRevenue - oldTotalRevenue >= 0) {
            beforeRevenue = "+" + (totalRevenue - oldTotalRevenue);
        } else {
            beforeRevenue = "-" + (oldTotalRevenue - totalRevenue);
        }
        dataAnalyVo.setBeforeRevenue(beforeRevenue);
    }
}
