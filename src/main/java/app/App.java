/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * Main.java is the application's main launch point. The application starts off at the main method which then builds a
 * Database connection with a local SQLite database, then the application launches, building the scenes utility class,
 * sets the stage, and displays the homescreen to the user. The class also contains a getter method used to get the SQL
 * database connection throughout the application.
 **********************************************************************************************************************/
package app;

import utils.SceneBuilder;
import utils.SceneName;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// The application supports, adding and reading functionalities
// Updating and deleting vehicle or any related records however, is not supported
public class App extends Application {
    private static Connection connection;
    private static SceneBuilder sceneBuilder;

    @Override public void start(Stage stage) {
        try {
            buildConnection();
            Font.loadFont(App.class.getResourceAsStream("/styles/PressStart2P-Regular.ttf"), 40);
            sceneBuilder = new SceneBuilder();
            stage.setResizable(false); // 840 x 1280 (HxW)
            stage.setScene(sceneBuilder.getSceneMap().get(SceneName.HOMESCREEN));
            stage.setTitle("Enterprise Rentals Inc. - Vehicle Tracking System");
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }


    public static SceneBuilder getSceneBuilder() { return sceneBuilder; }
    public static Connection getConnection() { return connection; }
    private static void buildConnection() {
        String dbPath = "src/database/EnterpriseRental.db";
        String url = "jdbc:sqlite:" + dbPath;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) { e.printStackTrace(); }
    }


    @Override public void stop() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
