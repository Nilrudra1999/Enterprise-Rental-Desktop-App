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

// Only responsible for housing the maintenance records for a car
// This system is very simple and each car has only 0 or 1 records, meant for recording and viewing data
public class MaintenanceRecord {
    private String date;
    private String desc;
    private double cost;

    // Constructor method, public ---------------------------------------------

    public MaintenanceRecord() { }

    // Getter methods, public -------------------------------------------------
    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public double getCost() {
        return cost;
    }

    // Setter methods, public ------------------------------------------------

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
