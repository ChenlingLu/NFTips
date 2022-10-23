package io.nftips.kunpeng.orm.entity;

import java.sql.Timestamp;

/**
 * 交易统计
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午4:02
 **/
public class NftTransactionsEntity {
    /**
     * 时间
     */
    private Timestamp time;

    /**
     * 交易次数（单位时间内）
     */
    private Integer tradingNum;
}
