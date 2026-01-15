package lda.services.market.domain.user.port;

import lda.services.market.domain.user.model.User;

import java.util.UUID;

public interface UserInput {
    User createUser(final User user);
    User getById(final UUID id);
}
