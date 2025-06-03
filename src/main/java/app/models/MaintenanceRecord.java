/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * MaintenanceRecord.java is a model class which holds all related information for a single maintenance record that
 * belongs to a single vehicle. The class contains getter methods for all data members and a parameterized constructor.
 * Includes the date of maintenance, description of work, separate service and materials costs.
 **********************************************************************************************************************/
package models;

import java.time.LocalDate;

public class MaintenanceRecord {
    private final LocalDate date;
    private final String desc;
    private final double serviceCost;
    private final double materialCost;

    public MaintenanceRecord(LocalDate date, double serviceCost, double materialCost, String desc) {
        this.date = date;
        this.serviceCost = serviceCost;
        this.materialCost = materialCost;
        this.desc = desc;
    }


    public LocalDate getDate() { return date; }
    public String getDesc() { return desc; }
    public double getServiceCost() { return serviceCost; }
    public double getMaterialCost() { return materialCost; }
}
