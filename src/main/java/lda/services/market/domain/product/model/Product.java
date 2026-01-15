package lda.services.market.domain.product.model;

import lda.services.market.domain.product.exception.ProductQuantityTooSmallException;
import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record Product (
        UUID id,
        String name,
        Integer quantity
) {

    public Product changeQuantity(final int quantity) {
        validateQuantity(quantity);
        return toBuilder()
                .quantity(quantity)
                .build();
    }

    private void validateQuantity(final int quantity) {
        if (quantity < 0) {
            throw new ProductQuantityTooSmallException(this.id());
        }
    }

}
