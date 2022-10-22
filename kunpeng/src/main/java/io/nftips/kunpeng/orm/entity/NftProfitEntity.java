package io.nftips.kunpeng.orm.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午6:08
 **/
@Data
public class NftProfitEntity {
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
