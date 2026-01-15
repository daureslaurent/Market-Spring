package lda.services.market.domain.user.model;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record User(
        UUID id,
        String name,
        String email
) {
}
