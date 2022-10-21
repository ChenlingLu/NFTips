package io.nftips.kunpeng.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/21 下午1:13
 **/
@Data
public class BaseVo implements Serializable {
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModify;
}
