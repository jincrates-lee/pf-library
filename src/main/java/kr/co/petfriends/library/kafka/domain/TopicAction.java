package kr.co.petfriends.library.kafka.domain;

public interface TopicAction {

    /**
     * 액션 Key 반환
     *
     * @return name
     */
    String getAction();

    /**
     * 액션 값 반환
     *
     * @return value
     */
    String getValue();
}
