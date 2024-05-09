package kr.co.petfriends.library.pg.strategy;

import kr.co.petfriends.library.pg.PgStrategy;
import kr.co.petfriends.library.pg.domain.PgType;
import org.springframework.stereotype.Component;

@Component
class PortOne implements PgStrategy {

    @Override
    public boolean isSatisfiedBy(PgType pgType) {
        return PgType.PORT_ONE.equals(pgType);
    }

    @Override
    public String pay() {
        return "PortOne 결제를 진행합니다.";
    }

}
