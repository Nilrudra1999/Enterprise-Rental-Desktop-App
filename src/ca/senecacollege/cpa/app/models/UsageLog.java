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

// Usage logs class records either 0 or only 1 set of usage records for a car, records and displays data
// Since each time a car is entered into the system a new car is made, each car has 0...1 usage logs
public class UsageLog {
    private String startDate;
    private String endDate;
    private int kmDriven;

    // Constructor, public --------------------------------------------------
    public UsageLog() { }

    // Getter methods, public -----------------------------------------------
    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    // Setter methods, public ----------------------------------------------

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }
}
