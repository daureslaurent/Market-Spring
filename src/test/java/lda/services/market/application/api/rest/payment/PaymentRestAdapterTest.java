package lda.services.market.application.api.rest.payment;

import lda.services.market.application.api.rest.payment.mapper.PaymentRestMapper;
import lda.services.market.application.api.rest.payment.model.PaymentResponse;
import lda.services.market.domain.payment.PaymentSampleTest;
import lda.services.market.domain.payment.port.PaymentInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentRestAdapterTest {

    @InjectMocks
    private PaymentRestAdapter paymentRestAdapter;

    @Mock
    private PaymentInput paymentInput;

    @Mock
    private PaymentRestMapper paymentRestMapper;

    @Test
    void givenGetPaymentById_whenNominal() {
        final var payment = PaymentSampleTest.domain();
        final var paymentResponse = PaymentResponse.builder()
                .id(payment.id())
                .provider(payment.provider())
                .status(payment.status())
                .amount(payment.amount())
                .createdAt(payment.createdAt())
                .build();

        // Given
        when(paymentInput.getById(payment.id()))
                .thenReturn(payment);
        when(paymentRestMapper.toResponse(payment))
                .thenReturn(paymentResponse);

        // When
        final var result = paymentRestAdapter.getPaymentById(payment.id());

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(paymentResponse);

        verify(paymentInput).getById(payment.id());
        verify(paymentRestMapper).toResponse(payment);
    }

}