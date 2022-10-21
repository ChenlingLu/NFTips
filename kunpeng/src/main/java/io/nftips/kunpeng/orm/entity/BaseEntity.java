package io.nftips.kunpeng.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhoujunwen
 * @date 2022-09-2022/9/19 下午2:24
 **/
@Data
public class BaseEntity<T> implements Serializable {
    @ApiModelProperty("创建时间")
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;
    @ApiModelProperty("修改时间")
    @TableField("gmt_modify")
    private LocalDateTime gmtModify;
}
