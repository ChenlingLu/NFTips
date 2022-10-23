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
     * 与前一次的差值
     */
    private Double preTransferValueDiff;
    /**
     * 累积收益
     */
    private Double totalProfit;
    /**
     * 平均价
     */
    private Double avgValue;
    /**
     * 交易次数
     */
    private Integer transactions;

    /**
     * 参与交易的账户数
     */
    private Integer accounts;
    /**
     * 购买指数
     */
    private Integer buyingIndex;
}
