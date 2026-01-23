package lda.services.market.domain.payment;

import lda.services.market.domain.payment.model.Payment;
import lda.services.market.domain.payment.model.PaymentStatus;
import lda.services.market.infra.persistence.payment.entity.PaymentEntity;
import lda.services.market.infra.persistence.payment.entity.PaymentStatusEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class PaymentSampleTest {

    private static final String TRANSACTION_ID = UUID.randomUUID().toString();
    private static final UUID ORDER_ID = UUID.randomUUID();
    private static final UUID USER_ID = UUID.randomUUID();

    public static Payment domain() {
        final var id = UUID.randomUUID();
        return domain(id);
    }

    public static Payment domain(final UUID id) {
        return Payment.builder()
                .id(id)
                .orderId(ORDER_ID)
                .userId(USER_ID)
                .provider("Wall_Pay")
                .status(PaymentStatus.PAID)
                .amount(BigDecimal.TEN)
                .transactionId(TRANSACTION_ID)
                .createdAt(Instant.EPOCH)
                .build();
    }

    public static PaymentEntity entity(final UUID id) {
        final var domain = domain(id);
        return PaymentEntity.builder()
                .id(domain.id())
                .userId(USER_ID)
                .orderId(domain.orderId())
                .provider(domain.provider())
                .status(PaymentStatusEntity.PAID)
                .amount(domain.amount())
                .transactionId(domain.transactionId())
                .createdAt(domain.createdAt())
                .build();

    }

    public static PaymentEntity entity() {
        final var domain = domain();
        return PaymentEntity.builder()
                .id(domain.id())
                .orderId(domain.orderId())
                .provider(domain.provider())
                .status(PaymentStatusEntity.PAID)
                .amount(domain.amount())
                .transactionId(domain.transactionId())
                .createdAt(domain.createdAt())
                .build();

    }

}
