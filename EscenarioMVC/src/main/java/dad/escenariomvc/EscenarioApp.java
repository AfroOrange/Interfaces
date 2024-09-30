package dad.escenariomvc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EscenarioApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        ModificarController modificarController = new ModificarController();

        Scene modificarScene = new Scene(modificarController.getRoot());

        Stage modificarStage = new Stage();
        modificarStage.setTitle("titulo");
        modificarStage.setScene(modificarScene);
        modificarStage.show();
    }
}
