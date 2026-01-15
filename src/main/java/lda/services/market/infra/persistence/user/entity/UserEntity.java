package lda.services.market.infra.persistence.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "APP_USER")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;
    private String name;
}
