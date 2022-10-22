package io.nftips.kunpeng.controller;

import cn.hutool.json.JSONUtil;
import io.nftips.kunpeng.common.Constants;
import io.nftips.kunpeng.orm.entity.ExplainEntity;
import io.nftips.kunpeng.service.SQLExplainService;
import io.nftips.kunpeng.util.CommonUtil;
import io.nftips.kunpeng.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static io.nftips.kunpeng.common.MappingPath.EXPLAIN_PROFIT_V1;
import static io.nftips.kunpeng.common.MappingPath.EXPLAIN_TOPN_V1;
import static io.nftips.kunpeng.util.CodeEnum.EXPLAIN_EXECUTE_FAIL;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午3:38
 **/
@RestController
public class SqlExplainController {
    @Autowired
    private HttpServletResponse response;

    @Resource
    private SQLExplainService sqlExplainService;

    @RequestMapping(value = {EXPLAIN_TOPN_V1})
    @ResponseBody
    public void selectTopNSqlExplain() {
        List<ExplainEntity> explainEntities  = sqlExplainService.selectTopNSqlExplain();

        R r = R.ok(explainEntities);
        if (explainEntities ==null) {
            r = R.error(EXPLAIN_EXECUTE_FAIL.getCode(), EXPLAIN_EXECUTE_FAIL.getDesc());
        }
        String result = JSONUtil.toJsonStr(r);
        CommonUtil.printResult(response, result);
    }

    @RequestMapping(value = {EXPLAIN_PROFIT_V1})
    @ResponseBody
    public void statisticsProfitSqlExplain(@RequestParam(value = Constants.CATEGORY_ID) String categoryId ) {
        List<ExplainEntity> explainEntities  = sqlExplainService.statisticsProfitSqlExplain(categoryId);

        R r = R.ok(explainEntities);
        if (explainEntities ==null) {
            r = R.error(EXPLAIN_EXECUTE_FAIL.getCode(), EXPLAIN_EXECUTE_FAIL.getDesc());
        }
        String result = JSONUtil.toJsonStr(r);
        CommonUtil.printResult(response, result);
    }
}

