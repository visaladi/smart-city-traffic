package com.example.smart_city_traffic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorEvent {
    private String sensorId;
    private String timestamp;   // ISO-8601 string
    private int vehicleCount;
    private double avgSpeed;    // km/h
}
