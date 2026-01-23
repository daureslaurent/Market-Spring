package lda.services.market.domain.payment.service;

import lda.services.market.domain.payment.PaymentSampleTest;
import lda.services.market.domain.payment.exception.PaymentNotFoundException;
import lda.services.market.domain.payment.port.PaymentOutput;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentOutput paymentOutput;

    @Test
    void givenGetById_whenNominal() {
        final var payment = PaymentSampleTest.domain();

        // Given
        when(paymentOutput.getById(payment.id()))
                .thenReturn(Optional.of(payment));

        // When
        final var result = paymentService.getById(payment.id());

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(payment);

        verify(paymentOutput).getById(payment.id());
    }

    @Test
    void givenGetById_whenNotFound_shouldThrowNotFound() {
        final var fakeId = UUID.randomUUID();

        // Given
        when(paymentOutput.getById(any()))
                .thenReturn(Optional.empty());

        // When
        final var throwed = assertThrows(PaymentNotFoundException.class,
                () -> paymentService.getById(fakeId));

        // Then
        assertThat(throwed).isNotNull();
        assertThat(throwed).isInstanceOf(PaymentNotFoundException.class);

        verify(paymentOutput).getById(fakeId);
    }

    @Test
    void givenGetByOrderId_whenNominal() {
        final var payment = PaymentSampleTest.domain();

        // Given
        when(paymentOutput.getByOrderId(payment.orderId()))
                .thenReturn(Optional.of(payment));

        // When
        final var result = paymentService.getByOrderId(payment.orderId());

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(payment);

        verify(paymentOutput).getByOrderId(payment.orderId());
    }

    @Test
    void givenGetByOrderId_whenNotFound_shouldThrowNotFound() {
        final var fakeId = UUID.randomUUID();

        // Given
        when(paymentOutput.getByOrderId(any()))
                .thenReturn(Optional.empty());

        // When
        final var throwed = assertThrows(PaymentNotFoundException.class,
                () -> paymentService.getByOrderId(fakeId));

        // Then
        assertThat(throwed).isNotNull();
        assertThat(throwed).isInstanceOf(PaymentNotFoundException.class);

        verify(paymentOutput).getByOrderId(fakeId);
    }

    @Test
    void givenCreatePayment_whenNominal() {
        final var payment = PaymentSampleTest.domain(null);
        final var paymentSaved = payment.toBuilder()
                .id(UUID.randomUUID())
                .build();

        // Given
        when(paymentOutput.save(payment)).thenReturn(paymentSaved);

        // When
        final var result = paymentService.createPayment(payment);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(paymentSaved);

        verify(paymentOutput).save(payment);
    }

    @Test
    void givenHaveRight_whenNominal() {
        final var paymentId = UUID.randomUUID();
        final var userId = UUID.randomUUID();

        // Given
        when(paymentOutput.haveRight(paymentId, userId))
                .thenReturn(true);

        // When
        final var result = paymentService.haveRight(paymentId, userId);

        // Then
        assertThat(result).isTrue();

        verify(paymentOutput).haveRight(paymentId, userId);
    }

}