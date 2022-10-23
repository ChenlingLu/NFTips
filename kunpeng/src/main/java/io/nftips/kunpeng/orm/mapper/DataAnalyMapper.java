package io.nftips.kunpeng.orm.mapper;

import io.nftips.kunpeng.orm.entity.NftResaleTimeEntity;
import io.nftips.kunpeng.vo.AverageRevenue;
import io.nftips.kunpeng.vo.PriceHistory;
import io.nftips.kunpeng.vo.TradingNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DataAnalyMapper {

    List<PriceHistory> selectPriceHistory(
            @Param("categoryId") String categoryId,
            @Param("passedDay") String passedDay,
            @Param("currentDay") String currentDay);

    List<AverageRevenue> selectAverageRevenueList( @Param("categoryId") String categoryId,
                                                   @Param("passedDay") String passedDay,
                                                   @Param("currentDay") String currentDay);

    Double selectTotalRevenue(@Param("categoryId") String categoryId,
                              @Param("passedDay") String passedDay,
                              @Param("oldPastDate") String oldPastDate);

    List<TradingNumber> selectTradingNumberList(@Param("categoryId") String categoryId,
                                                @Param("passedDay") String passedDay,
                                                @Param("currentDay") String currentDay);

    Integer selectTotalTradingNum(@Param("categoryId") String categoryId,
                                  @Param("passedDay") String passedDay,
                                  @Param("currentDay") String currentDay);


    List<NftResaleTimeEntity> resaleTime(@Param("categoryId") String categoryId,
                                         @Param("passedDay") String passedDay);


}
