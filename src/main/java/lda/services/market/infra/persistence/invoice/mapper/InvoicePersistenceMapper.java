package lda.services.market.infra.persistence.invoice.mapper;

import lda.services.market.domain.invoice.model.Invoice;
import lda.services.market.infra.persistence.invoice.entity.InvoiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoicePersistenceMapper {
    Invoice toDomain(final InvoiceEntity entity);
    InvoiceEntity toEntity(final Invoice invoice);
}
