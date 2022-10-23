//package io.nftips.kunpeng;
//
//import cn.hutool.json.JSONUtil;
//import io.nftips.kunpeng.util.CommonUtil;
//import io.nftips.kunpeng.util.R;
//import io.nftips.kunpeng.vo.DataAnalyVo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.servlet.http.HttpServletResponse;
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestDataAnalyController {
//
//    @Autowired
//    private HttpServletResponse response;
//
//    @Test
//    public void test(){
//        DataAnalyVo analyVo = new DataAnalyVo();
//        analyVo.setCategoryId("2qasd2a1213asdz");
//        // 历史价格
//        List<DataAnalyVo.PriceHistory> priceHistoryList = new ArrayList<>();
//        DataAnalyVo.PriceHistory priceHistory1 = new DataAnalyVo.PriceHistory();
//        priceHistory1.setTime(new Timestamp(16123123));
//        priceHistory1.setPrice(new BigDecimal(20));
//        DataAnalyVo.PriceHistory priceHistory2 = new DataAnalyVo.PriceHistory();
//        priceHistory2.setTime(new Timestamp(161123123));
//        priceHistory2.setPrice(new BigDecimal(40));
//        priceHistoryList.add(priceHistory1);
//        priceHistoryList.add(priceHistory2);
//        analyVo.setPriceHistory(priceHistoryList);
//
//        // 平均收益
//        List<DataAnalyVo.AverageRevenue> averageRevenueList = new ArrayList<>();
//        DataAnalyVo.AverageRevenue averageRevenue1 = new DataAnalyVo.AverageRevenue();
//        averageRevenue1.setRevenue(new BigDecimal(10));
//        averageRevenue1.setTime(new Timestamp(161123123));
//        DataAnalyVo.AverageRevenue averageRevenue2 = new DataAnalyVo.AverageRevenue();
//        averageRevenue2.setRevenue(new BigDecimal(10));
//        averageRevenue2.setTime(new Timestamp(161123123));
//        analyVo.setTotalRevenue(20D);
//        analyVo.setBeforeRevenue("-10.0");
//        averageRevenueList.add(averageRevenue1);
//        averageRevenueList.add(averageRevenue2);
//        analyVo.setAverageRevenue(averageRevenueList);
//
//        List<DataAnalyVo.TradingNumber> tradingNumberList = new ArrayList<>();
//        DataAnalyVo.TradingNumber tradingNumber1 = new DataAnalyVo.TradingNumber();
//        tradingNumber1.setTime(new Timestamp(161123123));
//        tradingNumber1.setTradingNum(10);
//        DataAnalyVo.TradingNumber tradingNumber2 = new DataAnalyVo.TradingNumber();
//        tradingNumber2.setTime(new Timestamp(161123123));
//        tradingNumber2.setTradingNum(20);
//        tradingNumberList.add(tradingNumber1);
//        tradingNumberList.add(tradingNumber2);
//        analyVo.setTradingNumber(tradingNumberList);
//        analyVo.setTotalTradingNum(30);
//        analyVo.setBeforeTradingNum("+10");
//
//
//        List<DataAnalyVo.ChangedHandsDay> changedHandsDayList = new ArrayList<>();
//        DataAnalyVo.ChangedHandsDay changedHandsDay1 = new DataAnalyVo.ChangedHandsDay();
//        changedHandsDay1.setDay(0.5);
//        changedHandsDay1.setTime(new Timestamp(161123123));
//        DataAnalyVo.ChangedHandsDay changedHandsDay2 = new DataAnalyVo.ChangedHandsDay();
//        changedHandsDay2.setDay(1.5);
//        changedHandsDay2.setTime(new Timestamp(161123123));
//        changedHandsDayList.add(changedHandsDay1);
//        changedHandsDayList.add(changedHandsDay2);
//        analyVo.setTotalChangeDay(2.0);
//        analyVo.setBeforeChangeDay("-0.5");
//
//        List<DataAnalyVo.HistoryTotalGains> historyTotalGains = new ArrayList<>();
//        DataAnalyVo.HistoryTotalGains historyTotalGains1 = new DataAnalyVo.HistoryTotalGains();
//        historyTotalGains1.setGains(1000D);
//        historyTotalGains1.setTime(new Timestamp(161123123));
//        DataAnalyVo.HistoryTotalGains historyTotalGains2 = new DataAnalyVo.HistoryTotalGains();
//        historyTotalGains2.setGains(3000D);
//        historyTotalGains2.setTime(new Timestamp(161123123));
//        historyTotalGains.add(historyTotalGains1);
//        historyTotalGains.add(historyTotalGains2);
//        analyVo.setTotalGains(4000D);
//        analyVo.setBeforeGains("+1000");
//
//        R r = R.ok(analyVo);
//        String result = JSONUtil.toJsonStr(r);
//
//        System.out.println("====>"+result);
//
//    }
//}
