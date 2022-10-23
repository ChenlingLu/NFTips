package io.nftips.kunpeng.util;

import java.text.NumberFormat;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午11:33
 **/
public class NumUtils {
    /**
     * @description java实现小数转百分数
     * @param data  小数
     * @return 返回百分数
     */
    public static String getPercent(double data) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(2);
        return numberFormat.format(data);
    }

}
