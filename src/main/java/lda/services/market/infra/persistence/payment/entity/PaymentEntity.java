package lda.services.market.infra.persistence.payment.entity;

import jakarta.persistence.*;
import lda.services.market.infra.persistence.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", unique = true)
    private OrderEntity order;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();
}
