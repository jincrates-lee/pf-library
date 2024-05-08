package kr.co.petfriends.library.pg;

import java.util.ArrayList;
import java.util.List;
import kr.co.petfriends.library.pg.domain.PgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PgStrategyFactory {

    private final List<PgStrategy> strategies;

    @Autowired
    public PgStrategyFactory(List<PgStrategy> strategies) {
        this.strategies = new ArrayList<>(strategies);
    }

    public PgStrategy findStrategy(PgType pgType) {
        return strategies.stream()
            .filter(it -> it.isSatisfiedBy(pgType))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("지원하지 않는 결제수단입니다. pgType=" + pgType));
    }
}
