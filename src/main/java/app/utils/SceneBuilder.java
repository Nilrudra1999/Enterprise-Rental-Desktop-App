/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * SceneBuilder.java is a utility class which contains the FXML loaders and scene object references for the application
 * It uses fxml files as a building block for constructing the UI elements, then using the respective controllers,
 * the elements are connected via annotations, and finally scenes are constructed from the FXML loaders. The class
 * contains a public non-parameterized constructor and public getter methods for scenes and loader object refs.
 **********************************************************************************************************************/
package utils;

import controllers.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneBuilder {
    private final Map<SceneName , FXMLLoader> loaderMap = new HashMap<>();
    private final Map<SceneName, Scene> sceneMap = new HashMap<>();

    public SceneBuilder() throws IOException {
        String scene1 = "/views/homescreen-view.fxml";
        String scene2 = "/views/vehicleDetails-view.fxml";
        String scene3 = "/views/vehicleForm-view.fxml";
        String scene4 = "/views/usageForm-view.fxml";
        String scene5 = "/views/maintenanceForm-view.fxml";

        loaderMap.put(SceneName.HOMESCREEN, new FXMLLoader(HomescreenController.class.getResource(scene1)));
        loaderMap.put(SceneName.VEHICLEDETAIL, new FXMLLoader(VehicleDetailsController.class.getResource(scene2)));
        loaderMap.put(SceneName.VEHICLEFORM, new FXMLLoader(VehicleFormController.class.getResource(scene3)));
        loaderMap.put(SceneName.USAGEFORM, new FXMLLoader(UsageFormController.class.getResource(scene4)));
        loaderMap.put(SceneName.MAINTENANCEFORM, new FXMLLoader(MaintenanceFormController.class.getResource(scene5)));

        sceneMap.put(SceneName.HOMESCREEN, new Scene(loaderMap.get(SceneName.HOMESCREEN).load()));
        sceneMap.put(SceneName.VEHICLEDETAIL, new Scene(loaderMap.get(SceneName.VEHICLEDETAIL).load()));
        sceneMap.put(SceneName.VEHICLEFORM, new Scene(loaderMap.get(SceneName.VEHICLEFORM).load()));
        sceneMap.put(SceneName.USAGEFORM, new Scene(loaderMap.get(SceneName.USAGEFORM).load()));
        sceneMap.put(SceneName.MAINTENANCEFORM, new Scene(loaderMap.get(SceneName.MAINTENANCEFORM).load()));
    }


    public Map<SceneName, FXMLLoader> getLoaderMap() { return loaderMap; }
    public Map<SceneName, Scene> getSceneMap() { return sceneMap; }
}
