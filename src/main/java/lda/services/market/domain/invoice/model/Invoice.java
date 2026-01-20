package lda.services.market.domain.invoice.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Invoice(
        UUID id,
        String provider,
        String status,
        BigDecimal amount,
        String transactionId,
        Instant createdAt
) {
}
