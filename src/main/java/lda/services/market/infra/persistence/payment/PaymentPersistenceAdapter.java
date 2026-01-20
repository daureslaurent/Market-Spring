package lda.services.market.infra.persistence.payment;

import lda.services.market.infra.persistence.payment.mapper.PaymentPersistenceMapper;
import lda.services.market.infra.persistence.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentPersistenceAdapter {

    private final PaymentRepository paymentRepository;
    private final PaymentPersistenceMapper mapper;

}
