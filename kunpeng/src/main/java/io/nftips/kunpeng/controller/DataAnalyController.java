package io.nftips.kunpeng.controller;

import cn.hutool.json.JSONUtil;
import io.nftips.kunpeng.service.DataAnalyService;
import io.nftips.kunpeng.util.CommonUtil;
import io.nftips.kunpeng.util.DataUtils;
import io.nftips.kunpeng.util.R;
import io.nftips.kunpeng.vo.DataAnalyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static io.nftips.kunpeng.common.MappingPath.Data_Analy_V1;

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
                             @RequestParam("categoryId") String categoryId,
                             @RequestParam("nftName")String nftName) {

       DataAnalyVo dataAnalyVo = dataAnalyService.statisticTradeInfo(day,categoryId,nftName);

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
