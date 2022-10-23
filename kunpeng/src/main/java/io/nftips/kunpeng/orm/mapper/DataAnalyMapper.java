package io.nftips.kunpeng.orm.mapper;

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
            @Param("nftName") String nftName,
            @Param("passedDay") String passedDay);

    List<AverageRevenue> selectAverageRevenueList( @Param("categoryId") String categoryId,
                                                   @Param("nftName") String nftName,
                                                   @Param("passedDay") String passedDay);

    Double selectTotalRevenue(@Param("categoryId") String categoryId,
                              @Param("nftName") String nftName,
                              @Param("passedDay") String passedDay);

    List<TradingNumber> selectTradingNumberList(@Param("categoryId") String categoryId,
                                                @Param("nftName") String nftName,
                                                @Param("passedDay") Integer passedDay);

    Integer selectTotalTradingNum(@Param("categoryId") String categoryId,
                                 @Param("nftName") String nftName,
                                 @Param("passedDay") String passedDay);
}
