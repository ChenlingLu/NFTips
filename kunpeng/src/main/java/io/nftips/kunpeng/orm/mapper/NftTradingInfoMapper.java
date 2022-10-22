package io.nftips.kunpeng.orm.mapper;

import io.nftips.kunpeng.orm.entity.NftTopInfoEntity;
import io.nftips.kunpeng.orm.entity.NftTradingInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhoujunwen
 * @since 2022-10-21 11:58:19
 */
@Mapper
public interface NftTradingInfoMapper extends BaseMapper<NftTradingInfoEntity> {
    /**
     * 查询TOP N的数据
     *
     * @param n TOP N
     *
     * @return
     */
    List<NftTopInfoEntity> selectTopN(@Param("topn") Integer n);

    /**
     * 执行计划结果
     * @param n
     * @return
     */
    List<String> selectTopN_Explain(@Param("topn") Integer n);
}
