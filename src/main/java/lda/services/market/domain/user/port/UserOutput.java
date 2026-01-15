package lda.services.market.domain.user.port;

import lda.services.market.domain.user.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserOutput {
    User save(final User user);
    Optional<User> getById(final UUID id);
    boolean existByEmail(final String email);
}
