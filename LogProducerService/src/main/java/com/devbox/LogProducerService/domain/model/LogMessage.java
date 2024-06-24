package com.devbox.LogProducerService.domain.model;

import lombok.Data;

@Data
public class LogMessage {
    private String message;
    private String level;
    private String timestamp;
}
