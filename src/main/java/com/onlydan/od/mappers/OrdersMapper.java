package com.onlydan.od.mappers;

import com.onlydan.od.dto.OrdersDTO;
import com.onlydan.od.entities.Orders;
import com.onlydan.od.entities.PaymentDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdersMapper {
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    @Mapping(target = "orderId", source = "paymentDetailsId", qualifiedByName = "mapPaymentDetails")
    OrdersDTO toDTO(Orders orders);

    @Named("mapPaymentDetails")
    default Long mapPaymentDetails(PaymentDetails paymentDetails) {
        return paymentDetails.getPaymentDetailsId();
    }

    List<OrdersDTO> toDTOs(List<Orders> ordersList);
}
