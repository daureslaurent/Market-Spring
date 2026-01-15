package lda.services.market.domain.user.exception;

public class UserEmailAlreadyExistException extends RuntimeException {
    public UserEmailAlreadyExistException(String email) {
        super(String.format("User already exist with email %s", email));
    }
}
