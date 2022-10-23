package io.nftips.kunpeng.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@ToString
public class ChangedHandsDay {

    /**
     * 时间
     */
    private Timestamp time;

    /**
     * 转手天数
     */
    private Double day;

}