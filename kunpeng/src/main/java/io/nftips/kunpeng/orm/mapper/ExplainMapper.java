package io.nftips.kunpeng.orm.mapper;

import io.nftips.kunpeng.orm.entity.ExplainEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhoujunwen
 * @date 2022-10-2022/10/23 上午3:31
 **/
@Mapper
public interface ExplainMapper {
    /**
     * 执行计划结果
     * @param n
     * @return
     */
    List<ExplainEntity> selectTopN_Explain(@Param("topn") Integer n);

    /**
     * 统计收益
     * @param categoryId
     * @return
     */
    List<ExplainEntity> statisticsProfit_Explain(@Param("categoryId") String categoryId);
}
