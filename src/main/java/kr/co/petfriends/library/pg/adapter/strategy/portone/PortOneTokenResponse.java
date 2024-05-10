package kr.co.petfriends.library.pg.adapter.strategy.portone;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PortOneTokenResponse {

    @JsonProperty(value = "access_token")
    private String token;

    @JsonProperty(value = "expired_at")
    private int expiredAt;

    @JsonProperty(value = "now")
    private int now;

    public PortOneTokenResponse(String token, int expiredAt, int now) {
        this.token = token;
        this.expiredAt = expiredAt;
        this.now = now;
    }
}
