package io.nftips.kunpeng.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午2:11
 **/
@Data
public class NFTInfoSearchVo {
    /**
     * NFT 基本信息
     */
    private BaseInfo baseInfo;

    /**
     * 交易摘要
     */
    private TradeSummary tradeSummary;

    /**
     * 持有时间
     */
    private HoldingPeriod holdingPeriod;


    /**
     * 基础信息
     */
    @Data
    public class BaseInfo {
        /**
         * 发行能量值
         */
        private Long issueEnergyValue;

        /**
         * 类别标识
         */
        private String categoryId;

        /**
         * 类别名称
         */
        private String categoryName;

        /**
         * 发送者
         */
        private String sender;

        /**
         * 链上link
         */
        private String chainLink;

        /**
         * 发生时间
         */
        private LocalDateTime occurTime;

        /**
         * 发行数量
         */
        private Integer issueCount;


    }

    /**
     * 交易摘要
     */
    @Data
    public class TradeSummary {
        /**
         * 类别标识
         */
        private String categoryId;
        /**
         * 最近一次交易时间
         */
        private LocalDateTime lastTransferTime;
        /**
         * 最近一次交易价值
         */
        private Double lastTransferValue;
        /**
         * 累积收益
         */
        private Double totalProfit;
        /**
         * 平均价
         */
        private Double avgValue;
    }

    /**
     * 持有时间
     */
    @Data
    public class HoldingPeriod {
        /**
         * 持有大于1年 value:12%, desc: >1Y
         */
        private Map<String, Object> lager;

        /**
         * 持有在小于1年，大于半年
         */
        private Map<String, Object> middle;
        /**
         * 持有小于半年
         */
        private Map<String, Object> small;
    }

}
