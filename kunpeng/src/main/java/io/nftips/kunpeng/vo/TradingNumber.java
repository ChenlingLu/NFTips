package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class TradingNumber {
    /**
     * 时间
     */
    private Timestamp time;

    /**
     * 交易次数（单位时间内）
     */
    private Integer tradingNum;
}
