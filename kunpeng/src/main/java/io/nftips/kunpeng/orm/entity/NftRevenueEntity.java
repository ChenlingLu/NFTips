package io.nftips.kunpeng.orm.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * NFT 交易价格统计实体
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午4:02
 **/
public class NftRevenueEntity {

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
}
