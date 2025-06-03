/***********************************************************************************************************************
 * Enterprise Rental Desktop Application
 *
 * SceneName.java is a utility enum class which contains the names of the different scenes currently within the app.
 * This class acts as labeling system for the various FXML scenes, and is used throughout the application when
 * changing scenes. This is because reading code like (SceneName.HOMESCREEN) while switching scenes is intuitive thus,
 * helps increase the readability of the code.
 **********************************************************************************************************************/
package utils;

public enum SceneName {
    HOMESCREEN,
    VEHICLEDETAIL,
    VEHICLEFORM,
    USAGEFORM,
    MAINTENANCEFORM
}
