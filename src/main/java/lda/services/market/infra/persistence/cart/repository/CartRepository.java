package lda.services.market.infra.persistence.cart.repository;

import lda.services.market.infra.persistence.cart.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, UUID> {
}
