package lda.services.market.infra.persistence.payment;

import lda.services.market.domain.payment.PaymentSampleTest;
import lda.services.market.infra.persistence.payment.mapper.PaymentPersistenceMapper;
import lda.services.market.infra.persistence.payment.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentPersistenceAdapterTest {

    @InjectMocks
    private PaymentPersistenceAdapter paymentPersistenceAdapter;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentPersistenceMapper mapper;

    @Test
    void givenGetById_WhenNominal() {
        final var id = UUID.randomUUID();
        final var paymentDomain = PaymentSampleTest.domain(id);
        final var paymentEntity = PaymentSampleTest.entity(id);

        // Given
        when(paymentRepository.findById(id))
                .thenReturn(Optional.of(paymentEntity));
        when(mapper.toDomain(paymentEntity))
                .thenReturn(paymentDomain);

        // When
        final var paymentTest = paymentPersistenceAdapter.getById(id);

        // Then
        assertThat(paymentTest).isNotNull();
        assertThat(paymentTest).isPresent();
        assertThat(paymentTest).contains(paymentDomain);

        verify(paymentRepository).findById(id);
        verify(mapper).toDomain(paymentEntity);
    }

    @Test
    void givenGetById_WhenNotFound_thenEmptyOptional() {
        final var id = UUID.randomUUID();

        // Given
        when(paymentRepository.findById(id))
                .thenReturn(Optional.empty());

        // When
        final var paymentTest = paymentPersistenceAdapter.getById(id);

        // Then
        assertThat(paymentTest).isNotNull();
        assertThat(paymentTest).isEmpty();

        verify(paymentRepository).findById(id);
        verify(mapper, never()).toDomain(any());
    }

    @Test
    void givenGetByOrderId_WhenNominal() {
        final var id = UUID.randomUUID();
        final var paymentDomain = PaymentSampleTest.domain(id);
        final var paymentEntity = PaymentSampleTest.entity(id);

        // Given
        when(paymentRepository.findByOrderId(id))
                .thenReturn(Optional.of(paymentEntity));
        when(mapper.toDomain(paymentEntity))
                .thenReturn(paymentDomain);

        // When
        final var paymentTest = paymentPersistenceAdapter.getByOrderId(id);

        // Then
        assertThat(paymentTest).isNotNull();
        assertThat(paymentTest).isPresent();
        assertThat(paymentTest).contains(paymentDomain);

        verify(paymentRepository).findByOrderId(id);
        verify(mapper).toDomain(paymentEntity);
    }

    @Test
    void givenGetByOrderId_WhenNotFound_thenEmptyOptional() {
        final var id = UUID.randomUUID();

        // Given
        when(paymentRepository.findByOrderId(id))
                .thenReturn(Optional.empty());

        // When
        final var paymentTest = paymentPersistenceAdapter.getByOrderId(id);

        // Then
        assertThat(paymentTest).isNotNull();
        assertThat(paymentTest).isEmpty();

        verify(paymentRepository).findByOrderId(id);
        verify(mapper, never()).toDomain(any());
    }

    @Test
    void givenSave_WhenNominal() {
        final var paymentDomain = PaymentSampleTest.domain(null);
        final var paymentEntity = PaymentSampleTest.entity(null);

        final var idGenerated = UUID.randomUUID();
        final var paymentEntitySaved = PaymentSampleTest.entity(idGenerated);
        final var paymentDomainSaved = PaymentSampleTest.domain(idGenerated);

        // Given
        when(mapper.toEntity(paymentDomain))
                .thenReturn(paymentEntity);
        when(paymentRepository.save(paymentEntity))
                .thenReturn(paymentEntitySaved);
        when(mapper.toDomain(paymentEntitySaved))
                .thenReturn(paymentDomainSaved);

        // When
        final var paymentTest = paymentPersistenceAdapter.save(paymentDomain);

        // Then
        assertThat(paymentTest).isNotNull();
        assertThat(paymentTest).isEqualTo(paymentDomainSaved);

        verify(mapper).toEntity(paymentDomain);
        verify(paymentRepository).save(paymentEntity);
        verify(mapper).toDomain(paymentEntitySaved);
    }

    @Test
    void givenHaveRight_whenNominal() {
        final var paymentId = UUID.randomUUID();
        final var userId = UUID.randomUUID();
        // Given
        when(paymentRepository.existsByIdAndUserId(
                paymentId,
                userId))
                .thenReturn(true);

        // When
        final var result = paymentPersistenceAdapter.haveRight(paymentId, userId);

        // Then
        assertThat(result).isTrue();

        verify(paymentRepository).existsByIdAndUserId(paymentId, userId);
    }



}