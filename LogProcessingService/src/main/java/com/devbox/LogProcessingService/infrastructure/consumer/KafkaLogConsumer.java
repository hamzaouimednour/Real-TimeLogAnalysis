package com.devbox.LogProcessingService.infrastructure.consumer;

import com.devbox.LogProcessingService.domain.model.LogMessage;
import com.devbox.LogProcessingService.domain.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLogConsumer {
    private final LogService logService;

    @KafkaListener(topics = "logs", groupId = "log_group")
    public void consume(LogMessage logMessage) {
        logService.processLog(logMessage);
    }
}
