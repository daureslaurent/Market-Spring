package lda.services.market.domain.payment.port;

import lda.services.market.domain.payment.model.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentOutput {
    Optional<Payment> getById(final UUID id);
    Optional<Payment> getByOrderId(final UUID orderId);
    Payment save(final Payment payment);
    boolean haveRight(final UUID paymentId, final UUID userId);
}
