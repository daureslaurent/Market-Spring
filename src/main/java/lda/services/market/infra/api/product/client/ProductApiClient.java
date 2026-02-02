package lda.services.market.infra.api.product.client;

import lda.services.market.domain.product.model.Product;
import lda.services.market.infra.api.PageResponse;
import lda.services.market.infra.api.product.model.ProductApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@FeignClient(value = "svc-catalog", url = "${api.svc-catalog.url}")
public interface ProductApiClient {

    @GetMapping(value = "/product")
    PageResponse<ProductApiResponse> getByPage(Pageable pageable);

    @GetMapping(value = "/product/{id}")
    Optional<ProductApiResponse> getById(@PathVariable UUID id);

    // Write part -> use command event instead

    @PostMapping(value = "/product")
    ProductApiResponse create(@RequestBody Product product);

    @PutMapping(value = "/product")
    ProductApiResponse update(@RequestBody Product product);

}
