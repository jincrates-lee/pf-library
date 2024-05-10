package kr.co.petfriends.library.pg.adapter.strategy.portone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PortOneTokenRequest {

    @JsonProperty(value = "imp_key")
    private String impKey;

    @JsonProperty(value = "imp_secret")
    private String impSecret;
}
