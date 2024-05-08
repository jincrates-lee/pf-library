package kr.co.petfriends.library.pg.domain;

import lombok.Getter;

@Getter
public enum PgType {
    PORT_ONE("포트원"),
    TOSS_PAY("토스페이"),
    SETTLE_PAY("세틀페이"),
    ;

    private final String description;

    PgType(String description) {
        this.description = description;
    }
}
