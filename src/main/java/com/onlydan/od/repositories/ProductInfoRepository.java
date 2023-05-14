package com.onlydan.od.repositories;

import com.onlydan.od.entities.Countries;
import com.onlydan.od.entities.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    Optional<List<ProductInfo>> getAllProductInfoByProductBrand(String productBrand);
    Optional<List<ProductInfo>> getAllProductInfoByProductCondition(String productCondition);
    Optional<List<ProductInfo>> getAllProductInfoByProductType(String productType);
    Optional<List<ProductInfo>> getAllProductInfoByCountryId(Countries countries);
}
