package kr.co.petfriends.library.pg;

import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;

public interface PayPreparePort {

    PayPrepareResponse prepare(PayPrepareRequest request);
}
