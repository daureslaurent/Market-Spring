package lda.services.market.infra.persistence.invoice;

import lda.services.market.infra.persistence.invoice.mapper.InvoicePersistenceMapper;
import lda.services.market.infra.persistence.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InvoicePersistenceAdapter {

    private final InvoiceRepository invoiceRepository;
    private final InvoicePersistenceMapper mapper;

}
