package kr.co.petfriends.library.kafka.domain;

import java.util.Collection;
import java.util.List;

/**
 * 도메인 이벤트를 발행하는 인터페이스 고유 식별자 또는 페이로드 객체를 사용하여 이벤트 발행
 */
public interface TopicPublisher {

    /**
     * 식별자를 전달 받아 도메인 이벤트를 발행한다. 1. 전달받은 식별자를 제로페이로드 방식으로 전달 할 수 있다. 2. 전달받은 식별자로 특정 포맷의 페이로드를 만들 수
     * 있다.
     *
     * @param ids    도메인 이벤트 식별자
     * @param action 발행할 이벤트의 액션
     * @param <K>    식별자 타입
     */
    <K> void publishByIds(Collection<K> ids, TopicAction action);

    default <K> void publishById(K id, TopicAction action) {
        publishByIds(List.of(id), action);
    }

    /**
     * 페이로드를 전달 받아 도메인 이벤트를 발행한다. 1. application layer 에서 생성한 페이로드로 도메인 이벤트를 발행할 수 있다.
     *
     * @param payloads 이벤트 페이로드
     * @param action   발행할 이벤트의 액션
     */
    void publishByPayloads(Collection<TopicPayload> payloads, TopicAction action);

    default void publishByPayload(TopicPayload payload, TopicAction action) {
        publishByPayloads(List.of(payload), action);
    }

    /**
     * 키, 페이로드 및 액션을 사용하여 새 도메인 이벤트를 생성한다.
     *
     * @param key     이벤트 키
     * @param payload 이벤트 페이로드
     * @param action  이벤트 액션
     * @return 생성된 도메인 이벤트
     */
    default Topic createTopic(String key, Object payload, TopicAction action) {
        return Topic.create(key, action, payload);
    }
}