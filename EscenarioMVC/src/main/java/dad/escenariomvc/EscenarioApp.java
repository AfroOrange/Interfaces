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
        modificarStage.setTitle("Modificar Valor");
        modificarStage.setScene(modificarScene);
        modificarStage.show();

        ProgressBarInterface progressBar = new ProgressBarInterface();
        Scene verScene = new Scene(progressBar.getRoot());

        Stage verStage = new Stage();
        verStage.setTitle("Progress Bar");
        verStage.setScene(verScene);
        verStage.show();

        progressBar.valueProperty().bind(modificarController.valueProperty());
    }
}
