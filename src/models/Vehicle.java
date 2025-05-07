package models;

public class Vehicle {
    private String model;
    private String make;
    private int year;
    private String type;
    MaintenanceRecord record;
    UsageLog log;

    public Vehicle(String model, String make, int year, String type) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.type = type;
    }

    public void setRecord(MaintenanceRecord record) { this.record = record; }
    public void setLog(UsageLog log) { this.log = log; }

    public String getModel() { return model; }
    public String getMake() { return make; }
    public int getYear() { return year; }
    public String getType() { return type; }
    public MaintenanceRecord getRecord() { return record; }
    public UsageLog getLog() { return log; }
}
