module app.enterprise_rental {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;


    opens app to javafx.fxml;
    opens utils to javafx.base;
    exports app;

    exports controllers;
    opens controllers;
}
