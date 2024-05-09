package kr.co.petfriends.library.kafka.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Objects;
import kr.co.petfriends.library.kafka.domain.Topic;
import kr.co.petfriends.library.kafka.exception.TopicDeserializerException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

public class TopicDeserializer implements Deserializer<Topic> {

    private final ObjectMapper objectMapper;


    public TopicDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Topic deserialize(String topic, Headers headers, byte[] data) {
        return deserialize(topic, data);
    }

    @Override
    public Topic deserialize(String topic, byte[] data) {
        Objects.requireNonNull(data, "data is not null");

        try {
            return objectMapper.readValue(data, Topic.class);
        } catch (IOException ex) {
            throw new TopicDeserializerException("topic data deserialize 중에 오류가 발생했습니다. "
                + "topic=" + topic, ex);
        }
    }
}