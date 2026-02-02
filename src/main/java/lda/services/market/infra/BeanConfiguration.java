package lda.services.market.infra;

import lda.services.market.domain.payment.port.PaymentOutput;
import lda.services.market.domain.payment.service.PaymentService;
import lda.services.market.domain.product.port.ProductOutput;
import lda.services.market.domain.product.service.ProductService;
import lda.services.market.domain.user.port.UserOutput;
import lda.services.market.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PaymentService paymentService(PaymentOutput paymentOutput) {
        return new PaymentService(paymentOutput);
    }

    @Bean
    ProductService productService(@Qualifier("productApiAdapter") ProductOutput productOutput) {
        return new ProductService(productOutput);
    }

    @Bean
    UserService userService(UserOutput userOutput) {
        return new UserService(userOutput);
    }

}
