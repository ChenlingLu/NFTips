package io.nftips.kunpeng.vo;

import lombok.Data;

@Data
public class CurrentPriceAndEnValue {
    /**
     * 当前价格
     */
    private Double currentPrice = 0D;

    /**
     * 能量值
     */
    private Integer currentEnergyValue = 0;
}
