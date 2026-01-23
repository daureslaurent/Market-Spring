package lda.services.market.application.api.rest.payment;

import lda.services.market.application.api.rest.payment.mapper.PaymentRestMapper;
import lda.services.market.application.api.rest.payment.model.PaymentResponse;
import lda.services.market.domain.payment.exception.PaymentNotFoundException;
import lda.services.market.domain.payment.port.PaymentInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentRestAdapter {

    private final PaymentInput paymentInput;
    private final PaymentRestMapper mapper;

    @GetMapping("/{id}")
    public PaymentResponse getPaymentById(@PathVariable final UUID id) {
        return mapper.toResponse(
                paymentInput.getById(id)
        );
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(PaymentNotFoundException ex) {
        return Map.of("message", ex.getMessage());
    }

}
