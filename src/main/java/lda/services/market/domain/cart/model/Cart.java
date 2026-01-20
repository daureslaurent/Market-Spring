package lda.services.market.domain.cart.model;

import lombok.Builder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
public record Cart(
        UUID id,
        UUID userId,
        List<CartItem> items,
        Instant updatedAt
) {
}
