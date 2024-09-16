package dad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Usar la Label de JavaFX, no confundirse
        Label saludoLabel = new Label();
        saludoLabel.setText("wenas");
        saludoLabel.setLayoutX(20); // Coordenada de la x para valor estático
        saludoLabel.setLayoutY(30);

        // Botones
        Button botonPrueba = new Button();
        botonPrueba.setText("wiwi");
        botonPrueba.setLayoutX(20);
        botonPrueba.setLayoutY(50);

        botonPrueba.setOnAction(actionEvent -> System.out.println("olee"));

        // Panel
        Pane root = new Pane();
        root.setStyle("-fx-background-color: cyan");
        root.getChildren().add(saludoLabel); // Se pueden agrupar en .addAll("elemento 1", "elemento 2", ...)
        root.getChildren().add(botonPrueba);


        // añadir siempre un elemento root y un parent
        Scene scene = new Scene(root, 320, 200);

        stage.setScene(scene);
        stage.setTitle("inmens messi");
        stage.setResizable(false);
        stage.show();
    }
}
