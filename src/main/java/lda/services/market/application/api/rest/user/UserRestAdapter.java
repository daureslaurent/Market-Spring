package lda.services.market.application.api.rest.user;

import lda.services.market.application.api.rest.user.mapper.UserRestMapper;
import lda.services.market.application.api.rest.user.model.UserCreateRequest;
import lda.services.market.application.api.rest.user.model.UserResponse;
import lda.services.market.domain.user.port.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestAdapter {

    private final UserInput userInput;
    private final UserRestMapper userRestMapper;

    @PostMapping
    public UserResponse createUser(@RequestBody final UserCreateRequest userCreateRequest) {
        final var user = userRestMapper.toUser(userCreateRequest);
        final var userCreated = userInput.createUser(user);
        return userRestMapper.toUserResponse(userCreated);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable final UUID id) {
        final var user = userInput.getById(id);
        return userRestMapper.toUserResponse(user);
    }

}
