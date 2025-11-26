package com.example.smart_city_traffic.util;

import com.example.smart_city_traffic.model.SensorEvent;

import java.time.Instant;
import java.util.List;
import java.util.Random;

public class RandomTrafficGenerator {

    private static final List<String> JUNCTIONS = List.of("J1", "J2", "J3", "J4");
    private static final Random RANDOM = new Random();

    public static SensorEvent generateEvent() {
        String sensorId = JUNCTIONS.get(RANDOM.nextInt(JUNCTIONS.size()));

        int vehicleCount = RANDOM.nextInt(46) + 5; // [5, 50]

        double avgSpeed;
        // 10% of the time, simulate critical congestion (very low speed)
        if (RANDOM.nextDouble() < 0.10) {
            avgSpeed = 2.0 + (8.0 - 2.0) * RANDOM.nextDouble();   // 2–8 km/h
        } else {
            avgSpeed = 15.0 + (60.0 - 15.0) * RANDOM.nextDouble(); // 15–60 km/h
        }

        avgSpeed = Math.round(avgSpeed * 100.0) / 100.0;

        return new SensorEvent(
                sensorId,
                Instant.now().toString(),
                vehicleCount,
                avgSpeed
        );
    }
}
