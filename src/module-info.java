module ca.senecacollege.cpa.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.cpa.app.test to javafx.fxml;
    exports ca.senecacollege.cpa.app.test;
    exports ca.senecacollege.cpa.app.controller;
    opens ca.senecacollege.cpa.app.controller to javafx.fxml;
}