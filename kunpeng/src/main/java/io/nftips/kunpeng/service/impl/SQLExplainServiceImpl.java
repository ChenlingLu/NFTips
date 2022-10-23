package io.nftips.kunpeng.service.impl;

import io.nftips.kunpeng.orm.entity.ExplainEntity;
import io.nftips.kunpeng.orm.mapper.ExplainMapper;
import io.nftips.kunpeng.service.SQLExplainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午3:36
 **/
@Service
public class SQLExplainServiceImpl implements SQLExplainService {
    private static final Logger logger = LoggerFactory.getLogger(SQLExplainServiceImpl.class);
    @Resource
    private ExplainMapper explainMapper;
    /**
     * TOP N SQL EXPLAIN
     *
     * @return
     */
    @Override
    public List<ExplainEntity> selectTopNSqlExplain() {
        return explainMapper.selectTopN_Explain(10);
    }

    /**
     * 交易摘要 SQL EXPLAIN
     *
     * @param categoryId
     *
     * @return
     */
    @Override
    public List<ExplainEntity> statisticsProfitSqlExplain(String categoryId) {
        return explainMapper.statisticsProfit_Explain(categoryId);
    }
}
