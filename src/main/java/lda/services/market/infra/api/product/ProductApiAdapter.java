package lda.services.market.infra.api.product;

import lda.services.market.domain.product.model.Product;
import lda.services.market.domain.product.port.ProductOutput;
import lda.services.market.infra.api.product.client.ProductApiClient;
import lda.services.market.infra.api.product.mapper.ProductApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ProductApiAdapter implements ProductOutput {

    private final ProductApiClient apiClient;
    private final ProductApiMapper mapper;

    @Override
    public Page<Product> getByPage(Pageable page) {
        final var pageData = apiClient.getByPage(page);

        final List<Product> content = pageData.content().stream()
                .map(mapper::toDomain)
                .toList();

        return new PageImpl<>(
                content,
                page,
                pageData.totalElements()
        );
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return apiClient.getById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
