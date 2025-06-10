/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * Main.java file is the main launch point of the application. It initializes the first scene and then passes control
 * to the main controller of the application
 **********************************************************************************************************************/
package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Form-view.fxml"));
        Parent root = loader.load();
        Scene sc = new Scene(root);
        primaryStage.setTitle("APD 545 Workshop 02 App");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
