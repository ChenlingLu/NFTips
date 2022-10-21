package io.nftips.kunpeng.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.nftips.kunpeng.orm.entity.BaseEntity;

import java.io.Serializable;
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
@TableName("bsn_nft_info")
public class NftInfoEntity extends BaseEntity<NftTopInfoEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 交易hash
     */
    @TableField("trading_hash")
    private String tradingHash;

    /**
     * 交易状态 1成功 0失败
     */
    @TableField("trading_status")
    private Integer tradingStatus;

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
     * 备注
     */
    @TableField("remark")
    private String remark;

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
     * 类别名称
     */
    @TableField("category_name")
    private String categoryName;

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
     * 链上link
     */
    @TableField("chain_link")
    private String chainLink;

    /**
     * 链上数据
     */
    @TableField("chain_data")
    private String chainData;

    /**
     * 链上link has
     */
    @TableField("chain_link_hash")
    private String chainLinkHash;

    /**
     * 源码
     */
    @TableField("`code`")
    private String code;

    /**
     * 数据源
     */
    @TableField("data_origin")
    private String dataOrigin;

    /**
     * 事件
     */
    @TableField("`events`")
    private String events;

    /**
     * 发生时间
     */
    @TableField("occur_time")
    private LocalDateTime occurTime;


}
