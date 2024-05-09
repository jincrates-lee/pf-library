package kr.co.petfriends.library.pg.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PayCancelRequest {

    private PayMethod payMethod;
}
