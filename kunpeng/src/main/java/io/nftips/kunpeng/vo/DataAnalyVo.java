package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DataAnalyVo {
    /**
     * nft类别标识
     */
    private String categoryId;

    private CurrentPriceAndEnValue currentPriceAndEnValue;
    /**
     * 历史价格
     */
    private List<PriceHistory> priceHistory;

    /**
     * 平均收益
     */
    private List<AverageRevenue> averageRevenue;
    /**
     * 总收益
     */
    private Double totalRevenue;

    /**
     * 平均收益
     */
    private Double averageRevenues;

    /**
     * 对比之前的收益(+12)
     */
    private String beforeRevenue;

    /**
     * 交易次数
     */
    private List<TradingNumber> tradingNumber;

    /**
     * 总交易次数
     */
    private Integer totalTradingNum;

    /**
     * 对比之前次数
     */
    private String beforeTradingNum;


    /**
     * 转手时间
     */
    private List<ChangedHandsDay> changedHandsDay;

    /**
     * 总转手天数
     */
    private Double totalChangeDay;

    /**
     * 平均转手天数
     */
    private Double averageChangeDay;

    /**
     * 对比之前的 算出转手天数(+1.5)
     */
    private String beforeChangeDay;

    /**
     * 历史最高涨幅
     */
    private List<HistoryTotalGains> historyTotalGains;

    /**
     * 总涨幅（单位时间内）
     */
    private Double totalGains;

    /**
     * 平均涨幅（单位时间内）
     */
    private Double averageGains;

    /**
     * 对比之前的 算出涨幅(-1000)
     */
    private String beforeGains;


}
