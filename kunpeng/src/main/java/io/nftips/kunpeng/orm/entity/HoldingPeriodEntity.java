package io.nftips.kunpeng.orm.entity;

import lombok.Data;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午6:08
 **/
@Data
public class HoldingPeriodEntity {
    /**
     * 持有大于1年 value:12%, desc: >1Y
     */
    private Double lagerRadio;

    /**
     * 持有在小于1年，大于半年
     */
    private Double middleRadio;
    /**
     * 持有小于半年
     */
    private Double smallRadio;
}
