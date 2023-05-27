package com.onlydan.od.mappers;

import com.onlydan.od.dto.PaymentMethodsDTO;
import com.onlydan.od.entities.PaymentMethods;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMethodsMapper {
    PaymentMethodsMapper INSTANCE = Mappers.getMapper(PaymentMethodsMapper.class);
    PaymentMethodsDTO toDTO(PaymentMethods paymentMethods);

    List<PaymentMethodsDTO> toDTOs(List<PaymentMethods> paymentMethodsList);
}
