package com.onlydan.od.mappers;

import com.onlydan.od.dto.PaymentDetailsDTO;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.entities.PaymentDetails;
import com.onlydan.od.entities.PaymentMethods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentDetailsMapper {
    PaymentDetailsMapper INSTANCE = Mappers.getMapper(PaymentDetailsMapper.class);

    @Mapping(target = "accountId", source = "account", qualifiedByName = "mapAccountId")
    @Mapping(target = "paymentMethodId", source = "paymentMethod", qualifiedByName = "mapPaymentMethodId")
    PaymentDetailsDTO toDTO(PaymentDetails paymentDetails);

    @Named("mapAccountId")
    default Long mapAccountId(Accounts account) {
        return account.getAccountId();
    }

    @Named("mapPaymentMethodId")
    default Long mapPaymentMethodId(PaymentMethods paymentMethod) {
        return paymentMethod.getPaymentMethodId();
    }

    List<PaymentDetailsDTO> toDTOs(List<PaymentDetails> paymentDetailsList);
}
