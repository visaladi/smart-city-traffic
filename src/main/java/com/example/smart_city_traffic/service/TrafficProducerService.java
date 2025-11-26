package com.example.smart_city_traffic.service;

import com.example.smart_city_traffic.model.SensorEvent;
import com.example.smart_city_traffic.util.RandomTrafficGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TrafficProducerService {

    private static final Logger log = LoggerFactory.getLogger(TrafficProducerService.class);

    private final KafkaTemplate<String, SensorEvent> kafkaTemplate;
    private static final String TOPIC = "traffic_raw";

    // Constructor injection (no Lombok)
    public TrafficProducerService(KafkaTemplate<String, SensorEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public SensorEvent sendRandomEvent() {
        SensorEvent event = RandomTrafficGenerator.generateEvent();
        kafkaTemplate.send(TOPIC, event.getSensorId(), event);
        log.info("Sent event to Kafka topic {}: {}", TOPIC, event);
        return event;
    }

    public SensorEvent sendCustomEvent(SensorEvent event) {
        kafkaTemplate.send(TOPIC, event.getSensorId(), event);
        log.info("Sent custom event to Kafka topic {}: {}", TOPIC, event);
        return event;
    }
}
