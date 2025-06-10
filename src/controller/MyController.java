/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * MyController.java is the main controller of the application and contains the all the logic for UI interactions as
 * well as a global variable for storing app wide data when using this app. Since no database is connected to the app
 * no information is kept when the app is closed.
 **********************************************************************************************************************/
package controller;

import models.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;



public class MyController implements Initializable {
    @FXML private TextField vdmodel, vdmake, vdyear, mrDesc, mrCost, ulkm;
    @FXML private ChoiceBox<String> vdtype;
    @FXML private DatePicker mrDate, ulstart, ulend;
    @FXML private Pane vdPane;

    private static final String NUMBER_PATTERN = "\\d*";
    private static final String DOUBLE_PATTERN = "\\d*(\\.\\d*)?";
    private final String[] vehicles = {"Sedan", "Truck", "SUV"};
    private static Collection<Vehicle> vehicleList = new ArrayList<>();


    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        // If statement below stops null exceptions when switching scenes
        if (vdtype != null) { vdtype.getItems().addAll(vehicles); }
    }
    public Pane getVdPane() { return vdPane; }


    public void save(ActionEvent event) {
        String model = vdmodel.getText().trim();
        String make = vdmake.getText().trim();
        String year = vdyear.getText().trim();
        String type = vdtype.getValue();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = (mrDate.getValue() != null) ? mrDate.getValue().format(formatter) : "";
        String desc = mrDesc.getText().trim();
        String cost = mrCost.getText().trim();

        String startDate = (ulstart.getValue() != null) ? ulstart.getValue().format(formatter) : "";
        String endDate = (ulend.getValue() != null) ? ulend.getValue().format(formatter) : "";
        String kmDriven = ulkm.getText().trim();

        if (model.isEmpty() || make.isEmpty() || (year.isEmpty() || !year.matches(NUMBER_PATTERN)) || type == null) {
            clearFields();
            showAlert("Error", "Either fields are missing or year entered is wrong!");
            return; // without vehicle details nothing is created
        }
        int intYear = Integer.parseInt(year);
        Vehicle v = new Vehicle(model, make, intYear, type);
        MaintenanceRecord record = new MaintenanceRecord();
        UsageLog log = new UsageLog();

        if (!date.isEmpty() || !desc.isEmpty() || (!cost.isEmpty() && cost.matches(DOUBLE_PATTERN))) {
            double doubleCost = Double.parseDouble(cost);
            record.setDate(date);
            record.setDesc(desc);
            record.setCost(doubleCost);
            v.setRecord(record);
        }
        if (!startDate.isEmpty() || !endDate.isEmpty() || (!kmDriven.isEmpty() && kmDriven.matches(NUMBER_PATTERN))) {
            int intKmDrvn = Integer.parseInt(kmDriven);
            log.setStartDate(startDate);
            log.setEndDate(endDate);
            log.setKmDriven(intKmDrvn);
            v.setLog(log);
        }
        vehicleList.add(v); // adds car to collection
        clearFields();
        showAlert("Success", "Vehicle saved!");
    }


    public void viewSummary(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>(); // pop-up of buttons
        dialog.setTitle("Vehicle Summarys");
        dialog.setHeaderText("Choose The Summary Table:");

        ButtonType btnDetails = new ButtonType("Vehicles");
        ButtonType btnRecord = new ButtonType("Maintenance Records");
        ButtonType btnLogs = new ButtonType("Usage Logs");
        ButtonType btnClose = new ButtonType("Close", ButtonType.CANCEL.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(btnDetails, btnRecord, btnLogs, btnClose);

        Optional<ButtonType> result = dialog.showAndWait(); // waits for user selection
        result.ifPresent(button -> {
            if (button == btnDetails) {
                detailsRender(event, "/views/Summary-view.fxml");
            } else if (button == btnRecord) {
                detailsRender(event, "/views/Record-view.fxml");
            } else if (button == btnLogs) {
                detailsRender(event, "/views/Usage-logs-view.fxml");
            }
        }); // If the user clicks "Close", dialog will close
    }


    public void clear(ActionEvent event) {
        clearFields();
        showAlert("Cleared", "Form cleared!");
    }


    public void goBack(ActionEvent event) {
        try {
            String filename = "/views/Form-view.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception err) { err.printStackTrace(); }
    }


    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private void clearFields() {
        vdmodel.clear();
        vdmake.clear();
        vdyear.clear();
        vdtype.setValue(null);

        mrDate.setValue(null);
        mrDesc.clear();
        mrCost.clear();

        ulstart.setValue(null);
        ulend.setValue(null);
        ulkm.clear();
    }


    private void detailsRender(ActionEvent event, String fileName) {
        try {
            if (vehicleList.isEmpty()) {
                showAlert("No data available", "Please add some vehicles.");
                return; // return to main scene
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));

            MyController controller = loader.getController();
            Pane vdPane = controller.getVdPane();
            switch (fileName) {
                case "/views/Summary-view.fxml" -> renderVehicleDetails(vdPane);
                case "/views/Record-view.fxml" -> renderVehicleRecords(vdPane);
                case "/views/Usage-logs-view.fxml" -> renderVehicleLogs(vdPane);
            }
            stage.show();
        } catch (Exception err) { err.printStackTrace(); }
    }


    private void renderVehicleDetails(Pane vdPane) {
        vdPane.getChildren().clear(); // clearing previous content
        double yOffset = 10;
        for (Vehicle v : vehicleList) {
            Text text = new Text("Model:" + v.getModel() + "  |  Make:" + v.getMake() +
                    "  |  Year:" + v.getYear() + "  |  Type:" + v.getType());
            text.setLayoutX(10);
            text.setLayoutY(yOffset);
            text.setFont(new Font(12));
            vdPane.getChildren().add(text);
            yOffset += 20;
        }
    }


    private void renderVehicleRecords(Pane vdPane) {
        vdPane.getChildren().clear(); // clearing previous content
        double yOffset = 10;
        for (Vehicle v : vehicleList) {
            if (v.getRecord() == null) continue;    // skip empty records
            Text text = new Text("Date:" + v.getRecord().getDate() + "  |  Desc:" + v.getRecord().getDesc() +
                    "  |  Cost:" + v.getRecord().getCost());
            text.setLayoutX(10);
            text.setLayoutY(yOffset);
            text.setFont(new Font(12));
            vdPane.getChildren().add(text);
            yOffset += 20;
        }
    }


    private void renderVehicleLogs(Pane vdPane) {
        vdPane.getChildren().clear(); // clearing previous content
        double yOffset = 10;
        for (Vehicle v : vehicleList) {
            if (v.getLog() == null) continue;    // skip empty records
            Text text = new Text("Start Date:" + v.getLog().getStartDate() +
                    "  |  End Date:" + v.getLog().getEndDate() + "  |  Driven:" + v.getLog().getKmDriven());
            text.setLayoutX(10);
            text.setLayoutY(yOffset);
            text.setFont(new Font(12));
            vdPane.getChildren().add(text);
            yOffset += 20;
        }
    }
}
