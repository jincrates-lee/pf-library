package kr.co.petfriends.library.pg.domain;

public interface PayCancel extends PayStrategy {

    PayCancelResponse cancel(PayCancelRequest request);
}
