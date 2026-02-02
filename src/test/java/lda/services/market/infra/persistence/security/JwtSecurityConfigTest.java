//package lda.services.market.infra.persistence.security;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpHeaders;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@ActiveProfiles("auth2")
//@SpringBootTest
//@AutoConfigureMockMvc
//@Import(TestSecurityBeansConfig.class)
//class JwtSecurityConfigTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void shouldAllowReadScope() throws Exception {
//        mockMvc.perform(get("/payment")
//                        .header(HttpHeaders.AUTHORIZATION, "Bearer mock-token"))
//                .andExpect(status().isOk());
//    }
//}