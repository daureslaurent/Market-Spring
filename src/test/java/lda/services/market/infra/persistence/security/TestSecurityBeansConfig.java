package lda.services.market.infra.persistence.security;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.DefaultOAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

import java.util.List;
import java.util.Map;

@TestConfiguration
public class TestSecurityBeansConfig {

    @Bean
    OpaqueTokenIntrospector opaqueTokenIntrospector() {
        return token -> {
            Map<String, Object> attributes = Map.of(
                    "sub", "test-user",
                    "scope", "read write"
            );

            return new DefaultOAuth2AuthenticatedPrincipal(
                    attributes,
                    List.of(
                            new SimpleGrantedAuthority("SCOPE_read"),
                            new SimpleGrantedAuthority("SCOPE_write")
                    )
            );
        };
    }
}
