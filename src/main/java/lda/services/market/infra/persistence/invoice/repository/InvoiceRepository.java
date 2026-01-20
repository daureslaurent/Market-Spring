package lda.services.market.infra.persistence.invoice.repository;

import lda.services.market.infra.persistence.invoice.entity.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, UUID> {
}
