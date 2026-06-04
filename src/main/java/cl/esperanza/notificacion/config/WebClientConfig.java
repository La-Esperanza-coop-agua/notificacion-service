package cl.esperanza.notificacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean(name = "webClientSocios") 
    public WebClient webClientSocios() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082/api/v1/socios").build();
    }
}