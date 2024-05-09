package kr.co.petfriends.library.pg;

import kr.co.petfriends.library.pg.domain.PayCancelRequest;
import kr.co.petfriends.library.pg.domain.PayCancelResponse;

public interface PayCancelPort {

    PayCancelResponse cancel(PayCancelRequest request);
}
