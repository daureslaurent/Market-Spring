package lda.services.market.domain.user.service;

import lda.services.market.domain.user.UserSampleTest;
import lda.services.market.domain.user.exception.UserEmailAlreadyExistException;
import lda.services.market.domain.user.exception.UserNotFoundException;
import lda.services.market.domain.user.port.UserOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserOutput userOutput;

    @Test
    void createUser_throw_when_userExist() {
        final var user = UserSampleTest.domain()
                .toBuilder()
                .id(null)
                .build();

        // Given
        when(userOutput.existByEmail(user.email()))
                .thenReturn(true);

        // When
        final var throwed = assertThrows(UserEmailAlreadyExistException.class, () ->
                userService.createUser(user));

        // Then
        assertThat(throwed).isNotNull();
        assertThat(throwed).isInstanceOf(UserEmailAlreadyExistException.class);

        verify(userOutput).existByEmail(user.email());
        verify(userOutput, never()).save(any());
    }

    @Test
    void createUser_when_nominal() {
        final var userReq = UserSampleTest.domain(null);
        final var userRes = userReq.toBuilder()
                .id(userReq.id())
                .build();

        // Given
        when(userOutput.save(userReq))
                .thenReturn(userRes);
        when(userOutput.existByEmail(userReq.email()))
                .thenReturn(false);
        // When
        final var userTest = userService.createUser(userReq);

        // Then
        assertThat(userTest).isNotNull();
        assertThat(userTest).isEqualTo(userRes);

        verify(userOutput).existByEmail(userReq.email());
        verify(userOutput).save(userReq);
    }

    @Test
    void getById_when_nominal() {
        final var user = UserSampleTest.domain();

        // Given
        when(userOutput.getById(user.id()))
                .thenReturn(Optional.of(user));

        // When
        final var userTest = userService.getById(user.id());

        // Then
        assertThat(userTest).isNotNull();
        assertThat(userTest).isEqualTo(user);

        verify(userOutput).getById(user.id());

    }

    @Test
    void getById_when_notFound_throw() {

        // Given
        when(userOutput.getById(any()))
                .thenReturn(Optional.empty());

        // When
        final var throwed = assertThrows(UserNotFoundException.class, () ->
                userService.getById(UUID.randomUUID()));

        // Then
        assertThat(throwed).isNotNull();
        assertThat(throwed).isInstanceOf(UserNotFoundException.class);

    }


}