package lda.services.market.application.api.rest.user.mapper;

import lda.services.market.application.api.rest.user.model.UserCreateRequest;
import lda.services.market.application.api.rest.user.model.UserResponse;
import lda.services.market.domain.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {
    User toUser(final UserCreateRequest userCreateRequest);
    UserResponse toUserResponse(final User user);
}
