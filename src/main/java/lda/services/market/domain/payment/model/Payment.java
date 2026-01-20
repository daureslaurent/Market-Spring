package lda.services.market.domain.payment.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Builder(toBuilder = true)
public record Payment(
        UUID id,
        String provider,
        String status,
        BigDecimal amount,
        String transactionId,
        Instant createdAt

) {
}
