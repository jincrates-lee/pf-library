package kr.co.petfriends.library.pg.adapter.strategy.portone;

import kr.co.petfriends.library.pg.domain.PayGatewayType;
import kr.co.petfriends.library.pg.domain.PayPrepare;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor
class PortOne implements PayPrepare {

    private final WebClient postOneWebClient;

    @Value("${pg.portone.key}")
    private String pgKey;

    @Value("${pg.portone.secretKey}")
    private String secretKey;

    @Override
    public boolean isSatisfiedBy(PayGatewayType payGatewayType) {
        return PayGatewayType.PORT_ONE.equals(payGatewayType);
    }

    @Override
    public PayPrepareResponse prepare(PayPrepareRequest request) {
        String authToken = getAuthToken();

        log.info("PortOne 결제를 준비합니다. authToken: {}", authToken);
        return null;
    }

    private String getAuthToken() {
        PortOneTokenRequest request = PortOneTokenRequest.builder()
            .impKey(pgKey)
            .impSecret(secretKey)
            .build();

        PortOneResponse<PortOneTokenResponse> response = postOneWebClient.post()
            .uri("/users/getToken")
            .bodyValue(request)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<PortOneResponse<PortOneTokenResponse>>() {
            })
            .block();

        if (response == null || response.getResponse() == null) {
            throw new RuntimeException("PortOne 토큰 요청에 실패했습니다.");
        }

        return response.getResponse().getToken();
    }
}
