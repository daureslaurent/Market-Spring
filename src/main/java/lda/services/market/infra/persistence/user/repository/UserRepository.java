package lda.services.market.infra.persistence.user.repository;

import lda.services.market.infra.persistence.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    boolean existsByEmail(final String email);

}
