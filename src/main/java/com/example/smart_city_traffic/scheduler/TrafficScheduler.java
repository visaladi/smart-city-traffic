package com.example.smart_city_traffic.scheduler;

import com.example.smart_city_traffic.model.SensorEvent;
import com.example.smart_city_traffic.service.TrafficProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TrafficScheduler {

    private static final Logger log = LoggerFactory.getLogger(TrafficScheduler.class);

    private final TrafficProducerService trafficProducerService;

    // ✅ Constructor injection (no Lombok)
    public TrafficScheduler(TrafficProducerService trafficProducerService) {
        this.trafficProducerService = trafficProducerService;
    }

    // ✅ Send a random event every 5 seconds
    @Scheduled(fixedRateString = "${app.traffic.scheduler.interval-ms:5000}")
    public void sendPeriodicRandomEvent() {
        SensorEvent event = trafficProducerService.sendRandomEvent();
        log.info("Scheduled RANDOM event sent: {}", event);
    }
}
