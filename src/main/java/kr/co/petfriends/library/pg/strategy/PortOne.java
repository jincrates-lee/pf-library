package kr.co.petfriends.library.pg.strategy;

import kr.co.petfriends.library.pg.PgStrategy;
import kr.co.petfriends.library.pg.domain.PgType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class PortOne implements PgStrategy {

    @Override
    public boolean isSatisfiedBy(PgType pgType) {
        return PgType.PORT_ONE.equals(pgType);
    }

    @Override
    public String pay() {
        log.info("PortOne 결제를 진행합니다.");
        return "PortOne 결제를 진행합니다.";
    }

}
