package lda.services.market.infra.persistence.cart;

import lda.services.market.infra.persistence.cart.mapper.CartPersistenceMapper;
import lda.services.market.infra.persistence.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CartPersistenceAdapter {

    private final CartRepository cartRepository;
    private final CartPersistenceMapper mapper;

}
