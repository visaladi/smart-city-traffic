package com.example.smart_city_traffic.controller;

import com.example.smart_city_traffic.model.SensorEvent;
import com.example.smart_city_traffic.service.TrafficProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/traffic")
@RequiredArgsConstructor
public class TrafficController {

    private final TrafficProducerService trafficProducerService;

    // Manually trigger sending one random event
    @PostMapping("/send-random")
    public ResponseEntity<SensorEvent> sendRandomEvent() {
        SensorEvent event = trafficProducerService.sendRandomEvent();
        return ResponseEntity.ok(event);
    }

    // Send a custom event (for testing from Postman)
    @PostMapping("/send")
    public ResponseEntity<SensorEvent> sendCustomEvent(@RequestBody SensorEvent event) {
        SensorEvent sent = trafficProducerService.sendCustomEvent(event);
        return ResponseEntity.ok(sent);
    }
}
