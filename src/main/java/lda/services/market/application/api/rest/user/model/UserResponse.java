package lda.services.market.application.api.rest.user.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record UserResponse(
        String id,
        String name,
        String email
) {
}
