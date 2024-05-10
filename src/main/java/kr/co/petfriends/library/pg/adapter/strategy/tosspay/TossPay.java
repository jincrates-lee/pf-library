package kr.co.petfriends.library.pg.adapter.strategy.tosspay;

import kr.co.petfriends.library.pg.domain.PayApprove;
import kr.co.petfriends.library.pg.domain.PayApproveRequest;
import kr.co.petfriends.library.pg.domain.PayApproveResponse;
import kr.co.petfriends.library.pg.domain.PayGatewayType;
import kr.co.petfriends.library.pg.domain.PayPrepare;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@RequiredArgsConstructor
class TossPay implements PayPrepare, PayApprove {

    private final WebClient tossPaymentWebClient;

    @Override
    public boolean isSatisfiedBy(PayGatewayType payGatewayType) {
        return PayGatewayType.TOSS_PAY.equals(payGatewayType);
    }

    @Override
    public PayPrepareResponse prepare(PayPrepareRequest request) {
        log.info("TossPay 결제를 준비합니다.");
        return null;
    }

    @Override
    public PayApproveResponse approve(PayApproveRequest request) {
        log.info("TossPay 결제를 승인합니다.");
        return null;
    }
}
