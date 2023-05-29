package com.onlydan.od.repositories.security;

import com.onlydan.od.dto.custom.TopCustomersDTO;
import com.onlydan.od.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> getAccountByAccountName(String accountName);
    Optional<Accounts> getAccountByEmail(String email);

    @Query(nativeQuery = true)
    List<TopCustomersDTO> getTopCustomersFromDateRange(@Param("topN")Integer topN,
                                                       @Param("startDate") LocalDate startDate,
                                                       @Param("endDate") LocalDate endDate);
}
