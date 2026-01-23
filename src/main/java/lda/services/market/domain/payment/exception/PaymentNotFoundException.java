package lda.services.market.domain.payment.exception;

import java.util.UUID;

public class PaymentNotFoundException extends RuntimeException {
  public PaymentNotFoundException(UUID paymentId) {
    super(String.format("Payment %s not found", paymentId != null
            ? paymentId
            : "(null value)"));
  }
}
