package kr.co.petfriends.library.kafka.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.kafka.annotation.KafkaListener;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface KafkaListenerWithAction {

    String id() default "";

    /**
     * 컨슈머 컨테이너 팩토리 설정
     */
    String containerFactory() default "kafkaListenerWithActionContainerFactory";

    String[] topics() default {};

    /**
     * 통합토픽 중 실제 처리할 액션 신규 추가 필드
     */
    String[] actions() default {};
}
