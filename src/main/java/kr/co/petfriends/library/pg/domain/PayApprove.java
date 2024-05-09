package kr.co.petfriends.library.pg.domain;

public interface PayApprove extends PayStrategy {

    PayApproveResponse approve(PayApproveRequest request);
}
