/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * UsageLog.java is a model class that holds all related information for a single usage record for a vehicle, it
 * contains getter methods for all data members of the class and a parameterized constructor. Includes a usage start
 * date, usage end date, and the total amount of KMs driven during that time period.
 **********************************************************************************************************************/
package models;

import java.time.LocalDate;

public class UsageLog {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int kmDriven;

    public UsageLog(LocalDate startDate, LocalDate endDate, int kmDriven) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.kmDriven = kmDriven;
    }


    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public int getKmDriven() { return kmDriven; }
}
