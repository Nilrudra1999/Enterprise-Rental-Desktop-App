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
package ca.senecacollege.cpa.app.controller;

import ca.senecacollege.cpa.app.models.MaintenanceRecord;
import ca.senecacollege.cpa.app.models.UsageLog;
import ca.senecacollege.cpa.app.models.Vehicle;
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

// Controller class handles UI elements and data by talking with the model classes
// When each event it proked then the model objects are created or viewed, no updates or deletes
public class MyController implements Initializable {
    @FXML private TextField vdmodel, vdmake, vdyear, mrDesc, mrCost, ulkm;
    @FXML private ChoiceBox<String> vdtype;
    @FXML private Button btnSave, btnClear, btnView, backBtn;
    @FXML private Pane vdPane;
    @FXML private DatePicker mrDate, ulstart, ulend;

    private static final String NUMBER_PATTERN = "\\d*";            // found this on Google
    private static final String DOUBLE_PATTERN = "\\d*(\\.\\d*)?";  // found this on Google
    private String[] vehicles = {"Sedan", "Truck", "SUV"};
    private static Collection<Vehicle> vehicleList = new ArrayList<>();

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        // If statement below stops null exceptions when switching scenes
        if (vdtype != null) { vdtype.getItems().addAll(vehicles); }
    }
    public Pane getVdPane() { return vdPane; }


    // Event handlers ------------------------------------------------------------------------------
    // Save event handler for creating objects when form's data is saved
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


    // View event handler for switching the scene depending on the user's click
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
                detailsRender(event, "/ca/senecacollege/cpa/app/views/Summary-view.fxml");
            } else if (button == btnRecord) {
                detailsRender(event, "/ca/senecacollege/cpa/app/views/Record-view.fxml");
            } else if (button == btnLogs) {
                detailsRender(event, "/ca/senecacollege/cpa/app/views/Usage-logs-view.fxml");
            }
        }); // If the user clicks "Close", dialog will close
    }


    // Clear event handler for clearing the form and doing nothing else
    public void clear(ActionEvent event) {
        clearFields();
        showAlert("Cleared", "Form cleared!");
    }


    // Go back event handler for the table view pages, sends user back to main scene
    public void goBack(ActionEvent event) {
        try {
            String filename = "/ca/senecacollege/cpa/app/views/Form-view.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }



    // Util private functions used by the controller -----------------------------------------------
    // Displays a pop-up alert for the event that just occured
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Clears the forms fields and sets the choice box to null
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

    // Sets the scene for the table view depending on the view filename passed
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
                case "/ca/senecacollege/cpa/app/views/Summary-view.fxml" -> renderVehicleDetails(vdPane);
                case "/ca/senecacollege/cpa/app/views/Record-view.fxml" -> renderVehicleRecords(vdPane);
                case "/ca/senecacollege/cpa/app/views/Usage-logs-view.fxml" -> renderVehicleLogs(vdPane);
            }
            stage.show();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    // Renders rows of vehicle details to output the contents of the collection
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

    // Renders rows of Maintenance records to output the contents of the collection
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

    // Renders rows of Usage log data to output the contents of the collection
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
