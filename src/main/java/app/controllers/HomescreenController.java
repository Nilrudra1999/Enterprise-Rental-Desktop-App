/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * HomescreenController.java the controller file for the homescreen, controls the buttons actions, tableview, and the
 * action related to the tableview. Is also responsible for loading in the visual data for the image view and uses a
 * helper method called setControllerReady() to load in vehicle data from the database, refreshing the tableview when
 * any changes occur.
 **********************************************************************************************************************/
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import models.Vehicle;

import java.net.URL;
import java.util.ResourceBundle;

public class HomescreenController implements Initializable {
    @FXML TableView<String> vehiclesTable;
    @FXML TableColumn<Vehicle, String> vehicleCol;
    private String imgURL = "/media/homescreenCar-img.png";

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        // todo
    }



    public void addVehicleToApp(ActionEvent event) {
        // todo
    }



    public void setControllerReady() {
        // todo
    }
}
