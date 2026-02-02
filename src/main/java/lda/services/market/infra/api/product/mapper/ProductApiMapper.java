package lda.services.market.infra.api.product.mapper;

import lda.services.market.domain.product.model.Product;
import lda.services.market.infra.api.product.model.ProductApiResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductApiMapper {
    Product toDomain(final ProductApiResponse productResponse);
}
