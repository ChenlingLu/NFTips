package io.nftips.kunpeng.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author zhoujunwen
 * @since 2022-10-21 11:58:19
 */
@Getter
@Setter
public class NftTradingInfoVo extends BaseVo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * NFT标识
     */
    private String ntfId;

    /**
     * NFT名称
     */
    private String ntfName;

    /**
     * 交易hash
     */
    private String tradingHash;

    /**
     * 交易类型
     */
    private String tradingType;

    /**
     * 类别标识
     */
    private String categoryId;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String recipient;

    /**
     * 交易额
     */
    private BigDecimal amount;

    /**
     * 区块高度
     */
    private String height;

    /**
     * 能量值
     */
    private Long energyValue;

    /**
     * 发生时间
     */
    private LocalDateTime occurTime;

}
