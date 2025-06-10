/*********************************************************************************************
 Workshop 2
 Course: Applications Development, APD545 - Semester 5
 Last Name: Mukhopadhyay
 First Name: Nilrudra
 ID: 134061175
 Section: NCC
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature: Nilrudra Mukhopadhyay
 Date: 2025-02-09
 *********************************************************************************************/
package ca.senecacollege.cpa.app.models;

// Vehicle Details class store various details about a vehicle, used for recording and viewing data
// Also includes a ref to a MaintenanceRecord and UsageLog classes since they are connected
public class Vehicle {
    private String model;
    private String make;
    private int year;
    private String type;
    MaintenanceRecord record;
    UsageLog log;

    // Overloaded constructor, public --------------------------------------
    public Vehicle(String model, String make, int year, String type) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.type = type;
    }

    // Setter methods, public ----------------------------------------------
    public void setRecord(MaintenanceRecord record) {
        this.record = record;
    }

    public void setLog(UsageLog log) {
        this.log = log;
    }

    // Getter methods, public ----------------------------------------------
    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public MaintenanceRecord getRecord() { return record; }

    public UsageLog getLog() { return log; }
}
