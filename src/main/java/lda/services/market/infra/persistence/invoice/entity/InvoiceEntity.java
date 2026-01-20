package lda.services.market.infra.persistence.invoice.entity;

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
@Table(name = "INVOICE")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", unique = true)
    private OrderEntity order;

    @Column(nullable = false, unique = true)
    private String invoiceNumber;

    @Column(nullable = false)
    private BigDecimal totalHt;

    @Column(nullable = false)
    private BigDecimal totalTtc;

    @Column(nullable = false)
    private BigDecimal taxAmount;

    @Column(nullable = false)
    private Instant issuedAt = Instant.now();
}
