package lda.services.market.infra.api.product.model;

import lda.services.market.domain.product.model.Tag;

import java.util.Set;
import java.util.UUID;

public record ProductApiResponse(
        UUID id,
        String name,
        String detail,
        Integer quantity,
        String pictureId,
        Set<Tag> tags
) {
}
