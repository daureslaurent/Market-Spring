package lda.services.market.application.api.rest.product.model;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record ProductDetalResponse(
        UUID id,
        String name,
        Integer quantity
) {
}
