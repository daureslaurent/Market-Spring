package lda.services.market.infra.persistence.payment.repository;

import lda.services.market.infra.persistence.payment.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
    Optional<PaymentEntity> findByOrderId(final UUID orderId);
    boolean existsByIdAndUserId(final UUID id, final UUID userId);
}
