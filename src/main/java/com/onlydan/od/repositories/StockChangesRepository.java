package com.onlydan.od.repositories;

import com.onlydan.od.entities.StockChanges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockChangesRepository extends JpaRepository<StockChanges, Long> {
}
