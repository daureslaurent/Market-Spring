package lda.services.market.infra.persistence.cart.mapper;

import lda.services.market.domain.cart.model.Cart;
import lda.services.market.domain.cart.model.CartItem;
import lda.services.market.infra.persistence.cart.entity.CartEntity;
import lda.services.market.infra.persistence.cart.entity.CartItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartPersistenceMapper {
    Cart toDomain(final CartEntity cartEntity);
    CartEntity toEntity(final Cart cart);

    CartItem toDomain(final CartItemEntity cartItemEntity);
    CartItemEntity toEntity(final CartItem cartItem);
}
