package com.example.smart_city_traffic.model;

public class SensorEvent {

    private String sensorId;
    private String timestamp;
    private int vehicleCount;
    private double avgSpeed;

    public SensorEvent() {
    }

    public SensorEvent(String sensorId, String timestamp, int vehicleCount, double avgSpeed) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.vehicleCount = vehicleCount;
        this.avgSpeed = avgSpeed;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "sensorId='" + sensorId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", vehicleCount=" + vehicleCount +
                ", avgSpeed=" + avgSpeed +
                '}';
    }
}
