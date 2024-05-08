package kr.co.petfriends.library.pg;

import kr.co.petfriends.library.pg.domain.PgType;

public interface PgStrategy {

    boolean isSatisfiedBy(PgType pgType);

    String pay();
}
