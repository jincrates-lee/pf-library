package kr.co.petfriends.library.pg.adapter.strategy.portone;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PortOneResponse<T> {

    private int code;
    private String message;
    private T response;

    @Builder
    public PortOneResponse(int code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    @Override
    public String toString() {
        return "PortOneCommonResponse{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", response=" + response +
            '}';
    }
}
