package kr.co.petfriends.library.kafka.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * 도메인 서비스로 전달할 페이로드 타입
 */
@Getter
public class TopicPayload {

    // 이벤트 식별자
    private final String id;
    // 도메인 데이터
    private final Object data;

    public TopicPayload(String id, Object data) {
        this.id = id;
        this.data = data;
    }

    /**
     * 단일 페이로드 타입을 생성한다.
     *
     * @param object   도메인 데이터
     * @param idGetter 식별자 추출메서드
     * @param <T>      도메인 데이터 타입
     * @return 생성된 이벤트 페이로드
     */
    public static <T> TopicPayload of(T object, Function<T, ?> idGetter) {
        final Object id = idGetter.apply(object);
        if ((!(id instanceof String) && !(id instanceof Number))) {
            throw new IllegalArgumentException(
                "id must be non-null value of type String or Number.");
        }
        return new TopicPayload(id.toString(), object);
    }

    /**
     * 페이로드 타입 리스트를 생성한다.
     *
     * @param objects  도메인 데이터 리스트
     * @param idGetter 식별자 추출메서드
     * @param <T>      도메인 데이터 타입
     * @return 생성된 이벤트 페이로드 리스트
     */
    public static <T> List<TopicPayload> of(List<T> objects, Function<T, ?> idGetter) {
        return objects.stream()
            .map(object -> TopicPayload.of(object, idGetter))
            .collect(Collectors.toList());
    }
}