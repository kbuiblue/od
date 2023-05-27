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
    private final CountriesRepository countriesRepository;

    //POST REQUESTS
    public ProductInfoDTO createProductInfo(ProductInfoDTO productCreationDTO) {
        Countries countries = countriesRepository.findById(productCreationDTO.getCountryId())
                .orElseThrow(AllExceptions::CountryNotFound);

        if (productInfoRepository.getProductInfoByProductName(productCreationDTO.getProductName()).isPresent()) {
            throw AllExceptions.ProductInfoAlreadyExists();
        }

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

        return productInfoMapper.INSTANCE.toDTO(savedProductInfo);
    }

    //PUT REQUESTS
    public ProductInfoDTO updateProductInfoByProductId(Long productId, ProductInfoDTO productUpdateDTO) {
        ProductInfo productInfo = productInfoRepository.findById(productId)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        Countries countries = countriesRepository.findById(productUpdateDTO.getCountryId())
                .orElseThrow(AllExceptions::CountryNotFound);

        productInfo.setStockPrice(productUpdateDTO.getStockPrice());
        productInfo.setProductBrand(productUpdateDTO.getProductBrand());
        productInfo.setProductName(productUpdateDTO.getProductName());
        productInfo.setProductYear(productUpdateDTO.getProductYear());
        productInfo.setProductType(productUpdateDTO.getProductType());
        productInfo.setProductCondition(productUpdateDTO.getProductCondition());
        productInfo.setDescription(productUpdateDTO.getDescription());
        productInfo.setCountryId(countries);

        ProductInfo savedProductInfo = productInfoRepository.save(productInfo);

        return productInfoMapper.INSTANCE.toDTO(savedProductInfo);
    }

    //GET REQUESTS
    public ProductInfoDTO getProductInfoByProductName(String productName) {
        ProductInfo productInfo = productInfoRepository.getProductInfoByProductName(productName)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        return productInfoMapper.INSTANCE.toDTO(productInfo);
    }

    public List<ProductInfoDTO> getAllProductInfoByProductBrand(String productBrand) {
        List<ProductInfo> productInfoList = productInfoRepository.getAllProductInfoByProductBrand(productBrand)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        if (productInfoList.isEmpty())
            throw AllExceptions.ProductInfoNotFound();

        return productInfoMapper.INSTANCE.toDTOs(productInfoList);
    }

    public List<ProductInfoDTO> getAllProductInfoByProductCondition(String productCondition) {
        List<ProductInfo> productInfoList = productInfoRepository.getAllProductInfoByProductCondition(productCondition)
                .orElseThrow(AllExceptions::InvalidInput);

        if (productInfoList.isEmpty())
            throw AllExceptions.InvalidInput();

        return productInfoMapper.INSTANCE.toDTOs(productInfoList);
    }

    public List<ProductInfoDTO> getAllProductInfoByProductType(String productType) {
        List<ProductInfo> productInfoList = productInfoRepository.getAllProductInfoByProductType(productType)
                .orElseThrow(AllExceptions::InvalidInput);

        if (productInfoList.isEmpty())
            throw AllExceptions.InvalidInput();

        return productInfoMapper.INSTANCE.toDTOs(productInfoList);
    }

    public List<ProductInfoDTO> getAllProductInfoByCountryId(String countryId) {
        Countries countries = countriesRepository.findById(countryId)
                .orElseThrow(AllExceptions::CountryNotFound);

        List<ProductInfo> productInfoList = productInfoRepository.getAllProductInfoByCountryId(countries)
                .orElseThrow(AllExceptions::InvalidInput);

        return productInfoMapper.INSTANCE.toDTOs(productInfoList);
    }

    public ProductInfoDTO getProductInfoByProductId(Long productId) {
        ProductInfo productInfo = productInfoRepository.findById(productId)
                .orElseThrow(AllExceptions::ProductInfoNotFound);

        return productInfoMapper.INSTANCE.toDTO(productInfo);
    }

    //DELETE REQUESTS
    public void deleteProductInfoByProductId(Long productId) {
        productInfoRepository.deleteById(productId);
    }
}
