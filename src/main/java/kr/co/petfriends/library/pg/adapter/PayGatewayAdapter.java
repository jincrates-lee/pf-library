package kr.co.petfriends.library.pg.adapter;

import kr.co.petfriends.library.pg.PayApprovePort;
import kr.co.petfriends.library.pg.PayPreparePort;
import kr.co.petfriends.library.pg.domain.PayApprove;
import kr.co.petfriends.library.pg.domain.PayApproveRequest;
import kr.co.petfriends.library.pg.domain.PayApproveResponse;
import kr.co.petfriends.library.pg.domain.PayMethod;
import kr.co.petfriends.library.pg.domain.PayPrepare;
import kr.co.petfriends.library.pg.domain.PayPrepareRequest;
import kr.co.petfriends.library.pg.domain.PayPrepareResponse;
import kr.co.petfriends.library.pg.domain.PayStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PayGatewayAdapter implements PayPreparePort, PayApprovePort {

    private final PayStrategyFactory<PayPrepare> payPrepareFactory;
    private final PayStrategyFactory<PayApprove> payApproveFactory;

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
}
