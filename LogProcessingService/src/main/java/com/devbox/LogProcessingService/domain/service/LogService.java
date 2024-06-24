package com.devbox.LogProcessingService.domain.service;

import com.devbox.LogProcessingService.domain.model.LogMessage;
import com.devbox.LogProcessingService.domain.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void processLog(LogMessage logMessage) {
        // Save to Elasticsearch
        logRepository.save(logMessage);

        // Save to Teradata (Assuming JPA repository is set up for Teradata)
        // teradataRepository.save(logMessage);
    }
}
