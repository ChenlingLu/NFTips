package io.nftips.kunpeng.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xianhu
 */
public class DataUtils {

    private static final FastDateFormat datetimeFormat = createDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 返回自定义时间格式化工具
     *
     * @param pattern
     * @return
     */
    public static FastDateFormat createDateFormat(String pattern) {
        return FastDateFormat.getInstance(pattern);
    }
    /**
     * 获取过去第几天的日期
     *
     * @param pastDay
     * @return yyyy-MM-dd 日期
     */
    public static String getPastDate(int pastDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - pastDay);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(today);
    }
    /**
     * 得到当前时间
     */
    public static String getCurrentTimeString() {
        return datetimeFormat.format(System.currentTimeMillis());
    }

}
