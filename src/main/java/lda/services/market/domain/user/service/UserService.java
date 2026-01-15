package lda.services.market.domain.user.service;

import lda.services.market.domain.user.exception.UserEmailAlreadyExistException;
import lda.services.market.domain.user.exception.UserNotFoundException;
import lda.services.market.domain.user.model.User;
import lda.services.market.domain.user.port.UserInput;
import lda.services.market.domain.user.port.UserOutput;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UserService implements UserInput {

    private final UserOutput userOutput;

    @Override
    public User createUser(User user) {
        if (userOutput.existByEmail(user.email())) {
            throw new UserEmailAlreadyExistException(user.email());
        }
        return userOutput.save(user);
    }

    @Override
    public User getById(UUID id) {
        return userOutput.getById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
