package kr.co.petfriends.library.pg.adapter;

import kr.co.petfriends.library.pg.PayApprovePort;
import kr.co.petfriends.library.pg.PayCancelPort;
import kr.co.petfriends.library.pg.PayPreparePort;
import kr.co.petfriends.library.pg.domain.PayApprove;
import kr.co.petfriends.library.pg.domain.PayApproveRequest;
import kr.co.petfriends.library.pg.domain.PayApproveResponse;
import kr.co.petfriends.library.pg.domain.PayCancel;
import kr.co.petfriends.library.pg.domain.PayCancelRequest;
import kr.co.petfriends.library.pg.domain.PayCancelResponse;
import kr.co.petfriends.library.pg.domain.PayMethod;
import kr.co.petfriends.library.pg.domain.PayPrepare;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import kr.co.petfriends.library.pg.domain.PayStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PayGatewayAdapter implements PayPreparePort, PayApprovePort, PayCancelPort {

    private final PayStrategyFactory<PayPrepare> payPrepareFactory;
    private final PayStrategyFactory<PayApprove> payApproveFactory;
    private final PayStrategyFactory<PayCancel> payCancelFactory;

    @Override
    public PayPrepareResponse prepare(PayPrepareRequest request) {
        PayMethod payMethod = request.getPayMethod();
        PayPrepare strategy = payPrepareFactory.findStrategy(payMethod);
        return strategy.prepare(request);
    }

    @Override
    public PayApproveResponse approve(PayApproveRequest request) {
        PayMethod payMethod = request.getPayMethod();
        PayApprove strategy = payApproveFactory.findStrategy(payMethod);
        return strategy.approve(request);
    }

    @Override
    public PayCancelResponse cancel(PayCancelRequest request) {
        PayMethod payMethod = request.getPayMethod();
        PayCancel strategy = payCancelFactory.findStrategy(payMethod);
        return strategy.cancel(request);
    }
}
