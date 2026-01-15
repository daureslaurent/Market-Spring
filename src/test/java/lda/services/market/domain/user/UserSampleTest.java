package lda.services.market.domain.user;

import lda.services.market.domain.user.model.User;
import lda.services.market.infra.persistence.user.entity.UserEntity;

import java.util.UUID;

public class UserSampleTest {

    public static User domain() {
        return domain(UUID.randomUUID());
    }

    public static User domain(final UUID id) {
        return User.builder()
                .id(id)
                .name("user")
                .email("user@mail.com")
                .build();
    }

    public static UserEntity entity() {
        final var domain = domain();
        return UserEntity.builder()
                .id(domain.id())
                .name(domain.name())
                .email(domain.email())
                .build();
    }


}
