package lda.services.market.domain.payment.port;

import lda.services.market.domain.payment.model.Payment;

import java.util.UUID;

public interface PaymentInput {
    Payment getById(final UUID id);
    Payment getByOrderId(final UUID orderId);
    Payment createPayment(final Payment payment);
    boolean haveRight(final UUID paymentId, final UUID userId);
}
