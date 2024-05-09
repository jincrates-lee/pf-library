package kr.co.petfriends.library.pg.domain;

public enum PayMethod {
    NO_PAYMENT_METHOD("결제수단 없음"),
    SETTLE_BANK("내통장결제"),
    TOSS_PAY("토스페이"),
    NAVER_PAY("네이버페이"),
    KAKAO_PAY("카카오페이"),
    SAMSUNG_PAY("삼성페이"),
    CARD("카드(신용/체크)"),
    PHONE("휴대폰 결제"),
    ACCOUNT_TRANSFER("계좌 이체"),
    ;

    private final String description;

    PayMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}