package kr.co.petfriends.library.pg.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PayPrepareRequest {

    private String payKey;
    private PayMethod payMethod;
    private Integer paymentPrice;
    private String productName;
    private String mobileOsCode;
    private String callbackUrl;
    private String cancelUrl;

    @Override
    public String toString() {
        return "PayPrepareRequest{" +
            "payKey='" + payKey + '\'' +
            ", payMethod=" + payMethod +
            ", paymentPrice=" + paymentPrice +
            ", productName='" + productName + '\'' +
            ", mobileOsCode='" + mobileOsCode + '\'' +
            ", callbackUrl='" + callbackUrl + '\'' +
            ", cancelUrl='" + cancelUrl + '\'' +
            '}';
    }
}