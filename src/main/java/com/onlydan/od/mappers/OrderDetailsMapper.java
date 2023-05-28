package com.onlydan.od.mappers;

import com.onlydan.od.dto.OrderDetailsDTO;
import com.onlydan.od.entities.OrderDetails;
import com.onlydan.od.entities.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);

    @Mapping(target = "productId", source = "productInfo", qualifiedByName = "mapProductId")
    @Mapping(target = "orderId", source = "order.orderId")
    OrderDetailsDTO toDTO(OrderDetails orderDetails);

    @Named("mapProductId")
    default Long mapProductId(ProductInfo productInfo) {
        return productInfo.getProductId();

    }

    List<OrderDetailsDTO> toDTOs(List<OrderDetails> orderDetailsList);
}
