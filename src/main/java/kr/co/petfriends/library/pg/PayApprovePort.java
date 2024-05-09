package kr.co.petfriends.library.pg;

import kr.co.petfriends.library.pg.domain.PayApproveRequest;
import kr.co.petfriends.library.pg.domain.PayApproveResponse;

public interface PayApprovePort {

    PayApproveResponse approve(PayApproveRequest request);
}
