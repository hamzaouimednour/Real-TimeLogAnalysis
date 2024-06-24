package com.devbox.LogProcessingService.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka // Replace with your desired group ID
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory(ProducerFactory<String, String> producerFactory) {
        return new DefaultKafkaConsumerFactory<>(consumerProperties(), new StringDeserializer(), new StringDeserializer());
    }

    @Bean
    public Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.95:9092"); // Replace with your Kafka broker address
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // Or "latest" depending on your needs
        // Add other consumer properties as needed
        return props;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group-id") // Replace with your topic name
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // Implement your message processing logic here
    }
}
