package kr.co.petfriends.library.pg.domain;

import java.util.Arrays;
import java.util.EnumSet;

public enum PayGatewayType {
    SETTLE_BANK("내통장결제", EnumSet.of(PayMethod.SETTLE_BANK)),
    TOSS_PAY("토스페이", EnumSet.of(PayMethod.TOSS_PAY)),
    PORT_ONE("포트원", EnumSet.of(
        PayMethod.SAMSUNG_PAY,
        PayMethod.CARD,
        PayMethod.PHONE,
        PayMethod.ACCOUNT_TRANSFER,
        PayMethod.NAVER_PAY,
        PayMethod.KAKAO_PAY
    )),
    ;

    private final String description;
    private final EnumSet<PayMethod> methods;

    PayGatewayType(String description, EnumSet<PayMethod> methods) {
        this.description = description;
        this.methods = methods;
    }

    public String getDescription() {
        return description;
    }

    public static PayGatewayType findByPayMethod(PayMethod payMethod) {
        return Arrays.stream(PayGatewayType.values())
            .filter(gateway -> gateway.methods.contains(payMethod))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("지원하지 않는 결제수단입니다. payMethod=" + payMethod));
    }
}
