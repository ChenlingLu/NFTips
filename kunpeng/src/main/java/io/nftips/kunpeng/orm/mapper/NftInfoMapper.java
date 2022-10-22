package io.nftips.kunpeng.orm.mapper;

import io.nftips.kunpeng.orm.entity.NFTMintStatisticsEntity;
import io.nftips.kunpeng.orm.entity.NftInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoujunwen
 * @since 2022-10-21 11:58:19
 */
@Mapper
public interface NftInfoMapper extends BaseMapper<NftInfoEntity> {
    /**
     * NFT类别ID
     * @param categoryId
     * @return
     */
    NFTMintStatisticsEntity statisticsBaseInfo(String categoryId);

    /**
     * 统计实际交易数
     * @param categoryId
     * @return
     */
    Long statisticsRealTradeCount(String categoryId);
}
