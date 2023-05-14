package com.onlydan.od.mappers;

import com.onlydan.od.dto.ProductInfoDTO;
import com.onlydan.od.entities.Countries;
import com.onlydan.od.entities.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductInfoMapper {
    ProductInfoMapper INSTANCE = Mappers.getMapper(ProductInfoMapper.class);
    @Mapping(target = "countryId", source = "countryId", qualifiedByName = "mapCountryId")
    ProductInfoDTO toDTO(ProductInfo productInfo);

    @Named("mapCountryId")
    default String mapCountryId(Countries countries) {
        return countries.getCountryId();
    }
    List<ProductInfoDTO> toDTOs(List<ProductInfo> productInfoList);
}
