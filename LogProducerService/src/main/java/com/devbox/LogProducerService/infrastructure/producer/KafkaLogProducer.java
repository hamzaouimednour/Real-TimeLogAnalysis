package com.devbox.LogProducerService.infrastructure.producer;

import com.devbox.LogProducerService.domain.model.LogMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaLogProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "logs";

    public void send(LogMessage logMessage) {
        kafkaTemplate.send(TOPIC, logMessage);
    }
}
