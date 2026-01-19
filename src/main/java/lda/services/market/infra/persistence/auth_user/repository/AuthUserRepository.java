package lda.services.market.infra.persistence.auth_user.repository;

import lda.services.market.infra.persistence.auth_user.entity.AuthUserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthUserRepository extends CrudRepository<AuthUserEntity, UUID> {
    Optional<AuthUserEntity> findByUsername(final String username);
}
