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

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        // todo
    }



    public void addVehicleToApp(ActionEvent event) {
        // todo
    }
}
