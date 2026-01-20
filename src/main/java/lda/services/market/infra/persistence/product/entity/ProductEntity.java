package lda.services.market.infra.persistence.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String detail;

    @Column(nullable = false)
    private Integer quantity;

    private String pictureId;

//    @OneToOne(
//            mappedBy = "product",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private CartItemEntity cartItems;

    @ManyToMany
//    @JoinTable(
//            name = "product_tags",
//            joinColumns = @JoinTable(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
    private Set<TagEntity> tags = new HashSet<>();
}
