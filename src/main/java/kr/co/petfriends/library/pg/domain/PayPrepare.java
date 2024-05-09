package kr.co.petfriends.library.pg.domain;

public interface PayPrepare extends PayStrategy {

    PayPrepareResponse prepare(PayPrepareRequest request);
}
