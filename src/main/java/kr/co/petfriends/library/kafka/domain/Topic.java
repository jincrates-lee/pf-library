package kr.co.petfriends.library.kafka.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Topic {

    private String id;
    private String action;
    private String actionValue;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime occurredAt;
    private Object data;

    private Topic() {
    }

    private Topic(String id, String action, String actionValue, LocalDateTime occurredAt,
        Object data) {
        this.id = Objects.requireNonNull(id);
        this.action = action;
        this.actionValue = actionValue;
        this.occurredAt = Objects.requireNonNull(occurredAt);
        this.data = Objects.requireNonNull(data);
    }

    public static Topic create(String id, TopicAction action, Object data) {
        return new Topic(id, action.getAction(), action.getValue(), LocalDateTime.now(), data);
    }
}
