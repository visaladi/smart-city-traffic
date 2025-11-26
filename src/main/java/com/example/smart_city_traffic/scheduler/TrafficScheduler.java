package com.example.smart_city_traffic.scheduler;

import com.example.smart_city_traffic.service.TrafficProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TrafficScheduler {

    private final TrafficProducerService trafficProducerService;

    // Send an event every 1 second
    @Scheduled(fixedRate = 1000)
    public void sendSensorDataPeriodically() {
        trafficProducerService.sendRandomEvent();
    }
}
