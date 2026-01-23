package lda.services.market.domain.payment;

import lda.services.market.infra.persistence.payment.repository.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentEndToEndApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    void beforeAll() {
        final var payment = PaymentSampleTest.entity(null);
        paymentRepository.deleteAll();
        paymentRepository.save(payment);
    }

    @AfterEach
    void afterEach() {
        paymentRepository.deleteAll();
    }

    @Test
    void givenPaymentApi_WhenGet_thenExpectedOk() {
        final var payment = PaymentSampleTest.entity(null);
        payment.setTransactionId(UUID.randomUUID().toString());
        final var paymentSaved = paymentRepository.save(payment);

        RestTestClient client = RestTestClient
                .bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();

        client.get().uri("/payment/" + paymentSaved.getId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void givenPaymentApi_WhenNotFound_thenExpectedNotFound() {
        RestTestClient client = RestTestClient
                .bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();

        client.get().uri("/payment/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }
}
