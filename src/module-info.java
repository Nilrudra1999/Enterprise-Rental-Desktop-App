module ca.senecacollege.cpa.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens test to javafx.fxml;
    exports test;
    exports controller;
    opens controller to javafx.fxml;
}