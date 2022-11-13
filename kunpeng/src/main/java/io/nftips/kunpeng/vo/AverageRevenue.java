package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class AverageRevenue {
    /**
     * 时间
     */
    private LocalDateTime time;
    /**
     * 收益（单位时间内）
     */
    private BigDecimal revenue;

}