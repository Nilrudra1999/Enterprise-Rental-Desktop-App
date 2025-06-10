/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * MaintenanceRecord.java is the class which contains the business logic for any vehicle's Maintenance.
 **********************************************************************************************************************/
package models;

public class MaintenanceRecord {
    private String date;
    private String desc;
    private double cost;

    public MaintenanceRecord() { }

    public String getDate() { return date; }
    public String getDesc() { return desc; }
    public double getCost() { return cost; }

    public void setDate(String date) { this.date = date; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setCost(double cost) { this.cost = cost; }
}
