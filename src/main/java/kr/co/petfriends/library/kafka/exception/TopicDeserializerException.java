package kr.co.petfriends.library.kafka.exception;

public class TopicDeserializerException extends RuntimeException {

    public TopicDeserializerException(String message) {
        super(message);
    }

    public TopicDeserializerException(String message, Throwable cause) {
        super(message, cause);
    }
}
