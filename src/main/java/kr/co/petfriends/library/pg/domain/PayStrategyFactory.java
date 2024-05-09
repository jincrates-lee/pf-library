package kr.co.petfriends.library.pg.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayStrategyFactory<T extends PayStrategy> {

    private final List<T> strategies;

    @Autowired
    public PayStrategyFactory(List<T> strategies) {
        this.strategies = new ArrayList<>(strategies);
    }

    public T findStrategy(PayMethod payMethod) {
        return strategies.stream()
            .filter(it -> it.isSatisfiedBy(PayGatewayType.findByPayMethod(payMethod)))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                "지원하지 않는 결제수단입니다. payMethod=" + payMethod));
    }
}
