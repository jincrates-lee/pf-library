package kr.co.petfriends.library.pg.domain;

public interface PayStrategy {

    boolean isSatisfiedBy(PayGatewayType payGatewayType);
}
