package lda.services.market.domain.user.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super(String.format("User %s not found", id.toString()));
    }
}
