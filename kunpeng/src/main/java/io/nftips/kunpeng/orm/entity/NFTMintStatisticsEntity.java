package io.nftips.kunpeng.orm.entity;

import java.time.LocalDateTime;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午3:49
 **/
public class NFTMintStatisticsEntity {
    /**
     * 发行能量值
     */
    private Long issueEnergyValue;

    /**
     * 类别标识
     */
    private String categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 链上link
     */
    private String chainLink;

    /**
     * 发生时间
     */
    private LocalDateTime occurTime;

    /**
     * 发行数量
     */
    private Integer issueCount;
}
