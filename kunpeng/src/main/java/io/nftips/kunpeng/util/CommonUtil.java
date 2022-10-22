package io.nftips.kunpeng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * 通用工具类
 */
public class CommonUtil {

    public static final String HTTP_PREFIX = "http://";
    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 输出结果(JSONObject)
     */
    public static void printResult(HttpServletResponse response, String result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(result);
        } catch (Exception e) {
            logger.error("print error", e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 异常时输出结果到UIG(JsonResult)
     */
    public static void printSuccessResult(HttpServletResponse response, String reasonCode, String result) {
        // modify by qionghui.fang at 2019/4/26 10:53 AM
        // 成功 返回200
        response.addHeader("Reason-Code", reasonCode);

        printResult(response, result);
    }


    /**
     * 获取请求参数
     *
     * @param request
     *
     * @return
     */
    public static Map<String, Object> convertOtherParamsWithoutFile(HttpServletRequest request) {
        Map<String, Object> otherParams = new HashMap<>();

        Enumeration names = request.getParameterNames();

        if (names != null) {
            while (names.hasMoreElements()) {
                String paramName = (String) names.nextElement();
                String paramValue = request.getParameter(paramName);
                otherParams.put(paramName, paramValue);
            }
        }

        return otherParams;
    }

}
