package lda.services.market.domain.cart.model;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record CartItem(
        UUID id,
        UUID productId,
        int quantity
) {
}
