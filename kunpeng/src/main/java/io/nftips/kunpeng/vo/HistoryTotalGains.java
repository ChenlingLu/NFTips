package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public  class HistoryTotalGains {
    /**
     * 时间
     */
    private Timestamp time;

    /**
     * 单位时间内涨幅 比如天数为2 则展示
     */
    private Double gains;

}