package lda.services.market.infra.persistence.product;

import lda.services.market.domain.product.model.Product;
import lda.services.market.domain.product.port.ProductOutput;
import lda.services.market.infra.persistence.product.mapper.ProductPersistenceMapper;
import lda.services.market.infra.persistence.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class ProductPersistenceAdapter implements ProductOutput {

    private final ProductRepository repository;
    private final ProductPersistenceMapper mapper;

    @Override
    public Page<Product> getByPage(Pageable page) {
        return repository.findAll(page)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        final var entity = mapper.toEntity(product);
        return mapper.toDomain(
                repository.save(entity)
        );
    }
}
