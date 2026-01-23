package lda.services.market.application.api.rest.payment.model;

import lda.services.market.domain.payment.model.PaymentStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
public record PaymentResponse(
        UUID id,
        String provider,
        PaymentStatus status,
        BigDecimal amount,
        Instant createdAt
) {
}
