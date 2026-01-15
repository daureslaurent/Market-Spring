package lda.services.market.domain.product;

import lda.services.market.domain.product.model.Product;
import lda.services.market.infra.persistence.product.entity.ProductEntity;

import java.util.UUID;

public class ProductSampleTest {

    public static Product domain() {
        return Product.builder()
                .id(UUID.randomUUID())
                .name("Sample product")
                .quantity(20)
                .build();
    }

    public static Product domain(final UUID id) {
        return Product.builder()
                .id(id)
                .name("Sample product")
                .quantity(20)
                .build();
    }

    public static ProductEntity entity() {
        final var domain = domain();
        return ProductEntity.builder()
                .id(domain.id())
                .name(domain.name())
                .quantity(domain.quantity())
                .build();

    }

}
