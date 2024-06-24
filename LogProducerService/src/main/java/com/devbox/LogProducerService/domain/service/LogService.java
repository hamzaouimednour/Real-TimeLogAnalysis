package com.devbox.LogProducerService.domain.service;

import com.devbox.LogProducerService.domain.model.LogMessage;
import com.devbox.LogProducerService.infrastructure.producer.KafkaLogProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final KafkaLogProducer kafkaLogProducer;

    public void ingestLog(LogMessage logMessage) {
        kafkaLogProducer.send(logMessage);
    }
}
