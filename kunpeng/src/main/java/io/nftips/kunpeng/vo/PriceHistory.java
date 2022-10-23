package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 历史价格
 */
@Data
@ToString
public class PriceHistory {
    /**
     * 时间
     */
    private LocalDateTime time;
    /**
     * 价格
     */
    private BigDecimal price;
}