package kr.co.petfriends.library.pg.adapter.strategy;

import kr.co.petfriends.library.pg.domain.PayApprove;
import kr.co.petfriends.library.pg.domain.PayApproveRequest;
import kr.co.petfriends.library.pg.domain.PayApproveResponse;
import kr.co.petfriends.library.pg.domain.PayCancel;
import kr.co.petfriends.library.pg.domain.PayCancelRequest;
import kr.co.petfriends.library.pg.domain.PayCancelResponse;
import kr.co.petfriends.library.pg.domain.PayGatewayType;
import kr.co.petfriends.library.pg.domain.PayPrepare;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class SettleBank implements PayPrepare, PayApprove, PayCancel {

    @Override
    public boolean isSatisfiedBy(PayGatewayType payGatewayType) {
        return PayGatewayType.SETTLE_BANK.equals(payGatewayType);
    }

    @Override
    public PayPrepareResponse prepare(PayPrepareRequest request) {
        log.info("SettleBank 결제를 준비합니다.");
        return null;
    }

    @Override
    public PayApproveResponse approve(PayApproveRequest request) {
        log.info("SettleBank 결제를 승인합니다.");
        return null;
    }

    @Override
    public PayCancelResponse cancel(PayCancelRequest request) {
        log.info("SettleBank 결제를 취소합니다.");
        return null;
    }
}
