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
package ca.senecacollege.cpa.app.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Adds launch function to the main method, which starts the application
// The start method sets the scene and the controller object from where the app is controlled
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/senecacollege/cpa/app/views/Form-view.fxml"));
        Parent root = loader.load();

        Scene sc = new Scene(root);
        primaryStage.setTitle("APD 545 Workshop 02 App");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
