package lda.services.market.infra.persistence.payment.mapper;

import lda.services.market.domain.payment.model.Payment;
import lda.services.market.infra.persistence.payment.entity.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {
    Payment toDomain(final PaymentEntity paymentEntity);
    PaymentEntity toEntity(final Payment payment);
}
