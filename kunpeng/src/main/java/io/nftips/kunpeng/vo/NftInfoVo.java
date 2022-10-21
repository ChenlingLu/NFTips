package io.nftips.kunpeng.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.nftips.kunpeng.orm.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 *
 * @author zhoujunwen
 * @since 2022-10-21 11:58:19
 */
@Getter
@Setter
public class NftInfoVo extends BaseVo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 交易hash
     */
    private String tradingHash;

    /**
     * 交易状态 1成功 0失败
     */
    private Integer tradingStatus;

    /**
     * 区块高度
     */
    private String height;

    /**
     * 能量值
     */
    private Long energyValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 交易类型
     */
    private String tradingType;

    /**
     * 类别标识
     */
    private String categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * NFT标识
     */
    private String ntfId;

    /**
     * NFT名称
     */
    private String ntfName;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String recipient;

    /**
     * 链上link
     */
    private String chainLink;

    /**
     * 链上数据
     */
    private String chainData;

    /**
     * 链上link has
     */
    private String chainLinkHash;

    /**
     * 源码
     */
    private String code;

    /**
     * 数据源
     */
    private String dataOrigin;

    /**
     * 事件
     */
    private String events;

    /**
     * 发生时间
     */
    private LocalDateTime occurTime;


}
