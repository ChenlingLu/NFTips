package io.nftips.kunpeng.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.nftips.kunpeng.orm.entity.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author zhoujunwen
 * @since 2022-10-21 11:58:19
 */
@Getter
@Setter
@TableName("bsn_nft_trading_info")
public class NftTradingInfoEntity extends BaseEntity<NftTradingInfoEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * NFT标识
     */
    @TableField("ntf_id")
    private String ntfId;

    /**
     * NFT名称
     */
    @TableField("ntf_name")
    private String ntfName;

    /**
     * 交易hash
     */
    @TableField("trading_hash")
    private String tradingHash;

    /**
     * 交易类型
     */
    @TableField("trading_type")
    private String tradingType;

    /**
     * 类别标识
     */
    @TableField("category_id")
    private String categoryId;

    /**
     * 发送者
     */
    @TableField("sender")
    private String sender;

    /**
     * 接收者
     */
    @TableField("recipient")
    private String recipient;

    /**
     * 交易额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 区块高度
     */
    @TableField("height")
    private String height;

    /**
     * 能量值
     */
    @TableField("energy_value")
    private Long energyValue;

    /**
     * 发生时间
     */
    @TableField("occur_time")
    private LocalDateTime occurTime;


}
