package io.nftips.kunpeng.util;

import lombok.Getter;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/22 下午1:50
 **/
public enum CodeEnum {
    /**
     *
     */
    IMAGE_NOT_ALLOW_EMPTY(4001, "图片不允许为空"),
    IMAGE_FEATURE_FAIL(4002, "提取图片特征失败"),
    IMAGE_SEARCH_FAIL(4003, "查询NFT异常"),
    NOT_FOUND_NFT(4004, "未查询到NFT藏品"),
    NOT_FOUND_CATEGORY_ID(4005, "未传递NFT类别标识"),

    EXPLAIN_EXECUTE_FAIL(5001, "SQL Explain执行失败");
    /**
     * CODE
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
