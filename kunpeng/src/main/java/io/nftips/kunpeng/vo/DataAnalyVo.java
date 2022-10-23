package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@ToString
public class DataAnalyVo {
    /**
     * nft类别标识
     */
    private String categoryId;

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
     * 对比之前的 算出涨幅(-1000)
     */
    private String beforeGains;

    @Data
    @ToString
    public static class HistoryTotalGains {
        /**
         * 时间
         */
        private Timestamp time;

        /**
         * 单位时间内涨幅 比如天数为2 则展示
         */
        private Double gains;

    }

    @Data
    @ToString
    public static class ChangedHandsDay {

        /**
         * 时间
         */
        private Timestamp time;

        /**
         * 转手天数
         */
        private Double day;

    }

    @Data
    @ToString
    public static class TradingNumber {
        /**
         * 时间
         */
        private Timestamp time;

        /**
         * 交易次数（单位时间内）
         */
        private Integer tradingNum;
    }

    @Data
    @ToString
    public static class AverageRevenue {
        /**
         * 时间
         */
        private Timestamp time;
        /**
         * 收益（单位时间内）
         */
        private BigDecimal revenue;

    }

    /**
     * 历史价格
     */
    @Data
    @ToString
    public static class PriceHistory {
        /**
         * 时间
         */
        private Timestamp time;
        /**
         * 价格
         */
        private BigDecimal price;
    }
}
