package com.devbox.LogProducerService.controller;
import com.devbox.LogProducerService.domain.model.LogMessage;
import com.devbox.LogProducerService.domain.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogProducerController {
    private final LogService logService;

    @PostMapping
    public ResponseEntity<Void> ingestLog(@RequestBody LogMessage logMessage) {
        logService.ingestLog(logMessage);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
