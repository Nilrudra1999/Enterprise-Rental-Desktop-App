/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * Vehicle.java class is a file which contains the business logic for any vehicle created using this app, the class
 * acts much like a record class but does allow slight alterations to the data of the vehicle objects.
 **********************************************************************************************************************/
package models;

public class Vehicle {
    private final String model;
    private final String make;
    private final int year;
    private final String type;
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
    public String getType() { return type;}
    public MaintenanceRecord getRecord() { return record; }
    public UsageLog getLog() { return log; }
}
