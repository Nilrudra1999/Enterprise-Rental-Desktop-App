/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * UsageLog.java contains the business logic for records of vehicle usage, it is a standard java class used like a
 * record class with information storage functionality.
 **********************************************************************************************************************/
package models;

public class UsageLog {
    private String startDate;
    private String endDate;
    private int kmDriven;

    public UsageLog() { }

    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public int getKmDriven() { return kmDriven; }

    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public void setKmDriven(int kmDriven) { this.kmDriven = kmDriven; }
}
