package io.nftips.kunpeng.util;

import lombok.Getter;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午1:50
 **/
public enum  CodeEnum {
    /**
     *
     */
    IMAGE_NOT_ALLOW_EMPTY(4001, "图片不允许为空"),
    IMAGE_FEATURE_FAIL(4002, "提取图片特征失败"),
    IMAGE_SEARCH_FAIL(4003, "查询NFT异常");

    /**
     *  CODE
     */
    @Getter
    private int code;
    @Getter
    private String desc;

    CodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
