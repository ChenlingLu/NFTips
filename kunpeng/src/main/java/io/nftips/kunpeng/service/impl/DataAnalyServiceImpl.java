package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.orm.mapper.DataAnalyMapper;
import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.util.DataUtils;
import io.nftips.kunpeng.vo.*;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class DataAnalyServiceImpl implements DataAnalyService {

    /**
     * nft详情线程池
     */
    public static final ThreadPoolExecutor QUERY_SUBMIT_POOL = new ThreadPoolExecutor(
            5, 5, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(5000),
            new CustomizableThreadFactory("QUERY_SUBMIT_POOL"));

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

        CompletableFuture<Void> priceHistoryListFuture = CompletableFuture.runAsync(
                () -> {
                    // 查询categoryId 对应passedDay的历史价格信息
                    List<PriceHistory> priceHistoryList = dataAnalyMapper.selectPriceHistory(categoryId, pastDate, currentDay);
                    dataAnalyVo.setPriceHistory(priceHistoryList);
                    // TODO 临时处理
                    CurrentPriceAndEnValue currentPriceAndEnValue = dataAnalyMapper.selectCurrentPriceAndEnValue(categoryId);
                    dataAnalyVo.setCurrentPriceAndEnValue(currentPriceAndEnValue);
                }
                , QUERY_SUBMIT_POOL);

        CompletableFuture<Void> averageRevenueListFuture = CompletableFuture.runAsync(
                () -> {
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
                    if (averageRevenueList.size() != 0) {
                        dataAnalyVo.setAverageRevenues(totalRevenue / averageRevenueList.size());
                    }

                    // 计算收益差
                    calculationAverageRevenue(dataAnalyVo, totalRevenue, oldTotalRevenue);
                }
                , QUERY_SUBMIT_POOL);
        CompletableFuture<Void> tradingNumberListFuture = CompletableFuture.runAsync(
                () -> {

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
                }
                , QUERY_SUBMIT_POOL);

        CompletableFuture.allOf(priceHistoryListFuture, averageRevenueListFuture, tradingNumberListFuture).join();

        if (dataAnalyVo.getPriceHistory().size() == 0) {
            return dataAnalyVo;
        }
        List<ChangedHandsDay> changedHandsDayList = new ArrayList<>();

        double totalChangeDay = 0D;
        for (int i = 0; i < new Random().nextInt(10); i++) {
            ChangedHandsDay changedHandsDay1 = new ChangedHandsDay();
            double day1 = new Random().nextInt(10);
            changedHandsDay1.setDay(day1);
            changedHandsDay1.setTime(new Timestamp(System.currentTimeMillis() - new Random().nextInt(10000)));
            totalChangeDay += day1;
            changedHandsDayList.add(changedHandsDay1);
        }
        dataAnalyVo.setTotalChangeDay(totalChangeDay);
        dataAnalyVo.setAverageChangeDay(totalChangeDay / changedHandsDayList.size());
        dataAnalyVo.setChangedHandsDay(changedHandsDayList);
        dataAnalyVo.setBeforeChangeDay("-" + new Random().nextInt(1000));

        List<HistoryTotalGains> historyTotalGains = new ArrayList<>();

        double totalGains = 0D;
        for (int i = 0; i < new Random().nextInt(20); i++) {
            HistoryTotalGains historyTotalGains1 = new HistoryTotalGains();
            double gains1 = new Random().nextInt(100000);
            historyTotalGains1.setGains(gains1);
            historyTotalGains1.setTime(new Timestamp(System.currentTimeMillis() - new Random().nextInt(10000)));
            historyTotalGains.add(historyTotalGains1);
            totalGains += gains1;
        }
        dataAnalyVo.setTotalGains(totalGains);
        dataAnalyVo.setAverageGains(totalGains / historyTotalGains.size());
        dataAnalyVo.setBeforeGains("+" + new Random().nextInt(5000));
        //历史交易次数
        dataAnalyVo.setHistoryTotalGains(historyTotalGains);
        return dataAnalyVo;
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
