package lda.services.market.application.api.rest.payment.mapper;

import lda.services.market.application.api.rest.payment.model.PaymentResponse;
import lda.services.market.domain.payment.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentRestMapper {
    PaymentResponse toResponse(final Payment payment);
}
