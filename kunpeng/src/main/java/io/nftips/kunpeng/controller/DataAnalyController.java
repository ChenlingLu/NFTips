package io.nftips.kunpeng.controller;

import cn.hutool.json.JSONUtil;
import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.util.CommonUtil;
import io.nftips.kunpeng.util.DataUtils;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.DataAnalyVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static io.nftips.kunpeng.common.MappingPath.Data_Analy_V1;
import static io.nftips.kunpeng.util.CodeEnum.NOT_FOUND_CATEGORY_ID;

/**
 * 数据分析接口
 */

@RestController
public class DataAnalyController {


    @Autowired
    private HttpServletResponse response;

    @Autowired
    private DataAnalyService dataAnalyService;

    /**
     * 数据分析接口
     * 第一次加载默认分析一天内的数据
     *
     * @param day
     * @param categoryId
     */
    @RequestMapping(value = {Data_Analy_V1})
    public void DataAnalysis(@RequestParam(value = "day", defaultValue = "1") Integer day,
                             @RequestParam("category_id") String categoryId) {

        if (StringUtils.isBlank(categoryId)) {
            R r = R.error(NOT_FOUND_CATEGORY_ID.getCode(), NOT_FOUND_CATEGORY_ID.getDesc());
            String result = JSONUtil.toJsonStr(r);
            CommonUtil.printResult(response, result);
            return;
        }
        if (day == null) {
            day = 1;
        }
        DataAnalyVo dataAnalyVo = null;
        try {
            dataAnalyVo = dataAnalyService.statisticTradeInfo(day, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        R r = R.ok(dataAnalyVo);
        String result = JSONUtil.toJsonStr(r);
        CommonUtil.printResult(response, result);
    }

    public static void main(String[] args) {
        // 当前时间
        String currentTimeString = DataUtils.getCurrentTimeString();

        //近两天
        String pastDate = DataUtils.getPastDate(2);

        //近两天的前两天
        String pastDate2 = DataUtils.getPastDate(4);
        System.out.println(currentTimeString);
        System.out.println(pastDate);
        System.out.println(pastDate2);
    }
}
