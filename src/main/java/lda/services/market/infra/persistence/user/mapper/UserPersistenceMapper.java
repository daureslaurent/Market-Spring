package lda.services.market.infra.persistence.user.mapper;

import lda.services.market.domain.user.model.User;
import lda.services.market.infra.persistence.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    User toDomain(final UserEntity userEntity);
    UserEntity toEntity(final User user);
}
