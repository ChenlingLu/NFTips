package io.nftips.kunpeng.service;

import io.nftips.kunpeng.orm.entity.ExplainEntity;

import java.util.List;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午3:33
 **/
public interface SQLExplainService {
    /**
     * TOP N SQL EXPLAIN
     * @return
     */
    List<ExplainEntity> selectTopNSqlExplain();

    /**
     * 交易摘要 SQL EXPLAIN
     * @param categoryId
     * @return
     */
    List<ExplainEntity> statisticsProfitSqlExplain(String categoryId);
}
