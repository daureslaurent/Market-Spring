package lda.services.market.domain.payment.service;


import lda.services.market.domain.payment.exception.PaymentNotFoundException;
import lda.services.market.domain.payment.model.Payment;
import lda.services.market.domain.payment.port.PaymentInput;
import lda.services.market.domain.payment.port.PaymentOutput;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PaymentService implements PaymentInput {

    private final PaymentOutput paymentOutput;

    @Override
    public Payment getById(UUID id) {
        return paymentOutput.getById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    @Override
    public Payment getByOrderId(UUID orderId) {
        return paymentOutput.getByOrderId(orderId)
                .orElseThrow(() -> new PaymentNotFoundException(null));
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentOutput.save(payment);
    }

    @Override
    public boolean haveRight(UUID paymentId, UUID userId) {
        return paymentOutput.haveRight(paymentId, userId);
    }
}
