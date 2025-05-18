/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * Vehicle.java is a model class that holds all vehicle related information as well as individual vehicle details for
 * all vehicles throughout the application. The class contains a parameterized constructor, setter methods for the
 * maintenance and usage logs which add individual records at a time, and getter methods for all data members.
 **********************************************************************************************************************/
package models;

import java.util.ArrayList;
import java.util.Collection;

public class Vehicle {
    private final int year;
    private final String make;
    private final String model;
    private final String type;
    private Collection<MaintenanceRecord> records;
    private Collection<UsageLog> logs;

    public Vehicle(int year, String make, String model, String type) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.type = type;
        records = new ArrayList<>();
        logs = new ArrayList<>();
    }


    public void setRecords(MaintenanceRecord record) { records.add(record); }
    public void setLogs(UsageLog log) { logs.add(log); }


    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getType() { return type; }


    public Collection<MaintenanceRecord> getRecords() { return records; }
    public Collection<UsageLog> getLogs() { return logs; }
}
