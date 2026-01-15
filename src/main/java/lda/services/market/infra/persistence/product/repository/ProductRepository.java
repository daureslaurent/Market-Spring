package lda.services.market.infra.persistence.product.repository;

import lda.services.market.infra.persistence.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends
        PagingAndSortingRepository<ProductEntity, UUID>,
        CrudRepository<ProductEntity, UUID> {
}
