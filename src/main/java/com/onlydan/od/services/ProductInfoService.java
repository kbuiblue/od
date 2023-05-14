package com.onlydan.od.services;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.entities.Countries;
import com.onlydan.od.entities.ProductInfo;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.ProductInfoMapper;
import com.onlydan.od.repositories.CountriesRepository;
import com.onlydan.od.repositories.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductInfoService {
    private final ProductInfoRepository productInfoRepository;
    private final ProductInfoMapper productInfoMapper;
    private final CountriesRepository countryRepository;

    public ProductInfoDTO createProductInfo(ProductInfoDTO productCreationDTO) {
        Countries countries = countryRepository.findById(productCreationDTO.getCountryId())
                .orElseThrow(AllExceptions::CountryNotFound);

        ProductInfo productInfo = ProductInfo.builder()
                .stockPrice(productCreationDTO.getStockPrice())
                .productBrand(productCreationDTO.getProductBrand())
                .productName(productCreationDTO.getProductName())
                .productYear(productCreationDTO.getProductYear())
                .productType(productCreationDTO.getProductType())
                .productCondition(productCreationDTO.getProductCondition())
                .description(productCreationDTO.getDescription())
                .countryId(countries)
                .build();

        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);

        return productInfoMapper.toDTO(savedProductInfo);
    }

    public List<ProductInfoDTO> getAllProductInfoByProductBrand(String productBrand) {
        List<ProductInfo> productInfoList = productInfoRepository.getAllProductInfoByProductBrand(productBrand)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        return productInfoMapper.INSTANCE.toDTOs(productInfoList);
    }

}
