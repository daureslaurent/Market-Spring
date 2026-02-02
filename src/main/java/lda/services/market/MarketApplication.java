package lda.services.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MarketApplication {

    static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

}
