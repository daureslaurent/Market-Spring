package lda.services.market.infra.persistence.user;

import lda.services.market.domain.user.model.User;
import lda.services.market.domain.user.port.UserOutput;
import lda.services.market.infra.persistence.user.mapper.UserPersistenceMapper;
import lda.services.market.infra.persistence.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UserPersistenceAdapter implements UserOutput {

    private final UserRepository repository;
    private final UserPersistenceMapper mapper;

    @Override
    public User save(User user) {
        final var entity = mapper.toEntity(user);
        final var saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
