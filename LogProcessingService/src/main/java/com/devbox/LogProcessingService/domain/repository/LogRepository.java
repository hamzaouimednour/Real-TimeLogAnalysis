package com.devbox.LogProcessingService.domain.repository;

import com.devbox.LogProcessingService.domain.model.LogMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ElasticsearchRepository<LogMessage, String> {
}