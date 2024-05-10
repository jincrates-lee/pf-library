package kr.co.petfriends.library.pg.adapter.strategy.tosspay;

import io.netty.handler.timeout.ReadTimeoutHandler;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@Configuration
public class TossPayConfig {

    @Value("${pg.tosspay.url}")
    private String baseUrl;

    @Value("${pg.tosspay.secretKey}")
    private String secretKey;

    @Bean
    public WebClient tossPaymentWebClient() {
        final String encodeSecretKey = Base64.getEncoder().encodeToString((secretKey + ":")
            .getBytes());

        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodeSecretKey)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .clientConnector(reactiveClientHttpConnector())
            .codecs(ClientCodecConfigurer::defaultCodecs)
            .build();
    }

    private ClientHttpConnector reactiveClientHttpConnector() {
        final ConnectionProvider provider = ConnectionProvider
            .builder("toss-payment")
            .build();

        final HttpClient httpClient = HttpClient.create(provider)
            .doOnConnected(it -> it.addHandlerLast(new ReadTimeoutHandler(30, TimeUnit.SECONDS)));

        return new ReactorClientHttpConnector(httpClient);
    }
}
