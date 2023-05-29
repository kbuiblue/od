package com.onlydan.od.repositories;

import com.onlydan.od.dto.BestSellingProductsDTO;
import com.onlydan.od.dto.DailyOrdersDTO;
import com.onlydan.od.dto.DailyRevenueDTO;
import com.onlydan.od.dto.WorstSellingProductsDTO;
import com.onlydan.od.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    @Query(nativeQuery = true)
    List<DailyRevenueDTO> getDailyRevenueFromDateRange(@Param("startDate") LocalDate startDate,
                                                       @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true)
    List<DailyOrdersDTO> getDailyOrdersFromDateRange(@Param("startDate") LocalDate startDate,
                                                     @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true)
    List<BestSellingProductsDTO> getBestSellingProductsFromDateRange(@Param("topN") Integer topN,
                                                                     @Param("startDate") LocalDate startDate,
                                                                     @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true)
    List<WorstSellingProductsDTO> getWorstSellingProductsFromDateRange(@Param("topN") Integer topN,
                                                                       @Param("startDate") LocalDate startDate,
                                                                       @Param("endDate") LocalDate endDate);
}
