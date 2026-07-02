package cl.esperanza.notificacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient sociosWebClient(@Value("${socios.service.url:http://localhost:8082/api/v1/socios}") String sociosServiceUrl) {
        return WebClient.builder().baseUrl(sociosServiceUrl).build();
    }
}
