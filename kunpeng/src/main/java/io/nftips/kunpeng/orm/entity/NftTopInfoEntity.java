package io.nftips.kunpeng.orm.entity;

import io.nftips.kunpeng.vo.BaseVo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * NFT 投资指数
 *
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 下午1:20
 **/
@Data
@Getter
@Setter
public class NftTopInfoEntity extends BaseEntity<NftTopInfoEntity> {
    private static final long serialVersionUID = 8642483020062860069L;
    /**
     * 类别标识
     */
    private String categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 发行者钱包地址
     */
    private String sender;

    /**
     * 发行能量总值
     */
    private Long issueEnergyValue;

    /**
     * 投资价值
     */
    private Double worth;

    private String chainLink;
}
