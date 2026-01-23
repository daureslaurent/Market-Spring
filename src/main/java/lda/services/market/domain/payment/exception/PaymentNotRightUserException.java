package lda.services.market.domain.payment.exception;

import java.util.UUID;

public class PaymentNotRightUserException extends RuntimeException {
  public PaymentNotRightUserException(UUID paymentId) {
    super(String.format("User haven't right for %s payment", paymentId != null
            ? paymentId
            : "(null value)"));
  }
}
