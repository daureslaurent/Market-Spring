package lda.services.market.infra.persistence.payment;

import lda.services.market.domain.payment.model.Payment;
import lda.services.market.domain.payment.port.PaymentOutput;
import lda.services.market.infra.persistence.payment.mapper.PaymentPersistenceMapper;
import lda.services.market.infra.persistence.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PaymentPersistenceAdapter implements PaymentOutput {

    private final PaymentRepository paymentRepository;
    private final PaymentPersistenceMapper mapper;

    @Override
    public Optional<Payment> getById(UUID id) {
        return paymentRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Payment> getByOrderId(UUID orderId) {
        return paymentRepository.findByOrderId(orderId)
                .map(mapper::toDomain);
    }

    @Override
    public Payment save(Payment payment) {
        final var paymentEntity = mapper.toEntity(payment);
        return mapper.toDomain(
                paymentRepository.save(paymentEntity)
        );
    }

    @Override
    public boolean haveRight(UUID paymentId, UUID userId) {
        return paymentRepository
                .existsByIdAndUserId(paymentId, userId);
    }


}
