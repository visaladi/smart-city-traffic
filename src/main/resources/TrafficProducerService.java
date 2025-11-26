package com.example.smart_city_traffic.service;

import com.example.smart_city_traffic.model.SensorEvent;
import com.example.smart_city_traffic.util.RandomTrafficGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrafficProducerService {

    private final KafkaTemplate<String, SensorEvent> kafkaTemplate;
    private static final String TOPIC = "traffic_raw";

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
