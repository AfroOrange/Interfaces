package dad.holafx.enhanced;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HolaFXApp extends Application {

    // Declarar las variables privadas antes de inicializar el Stage
    private TextField nombreText;
    private Button saludarButton;
    private Label saludoLabel;

    @Override
    public void start(Stage stage) throws Exception {

        // Inicializar las variables
        nombreText = new TextField();
        nombreText.setPromptText("Introducir nombre de la persona para saludar");

        saludarButton = new Button("Saludar");

        saludoLabel = new Label();

        // Eventos para el botón
        saludarButton.setDefaultButton(true);
        saludarButton.setOnAction(e -> onSaludarAction(e)); // válido de los dos métodos, preferible el que usa | this:: |
        saludarButton.setOnAction(this::onSaludarAction);

        // Set up the layout
        VBox root = new VBox();
        root.setPadding(new Insets(50));
        root.setSpacing(10);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(nombreText, saludarButton, saludoLabel);

        // Set up the scene and stage
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Enhanced HolaFX");
        stage.setScene(scene);
        stage.show();
    }

    // Método extraído del botón
    private void onSaludarAction(ActionEvent e) {
        String nombre = nombreText.getText();
        String saludo = "Buenas " + nombre;
        saludoLabel.setText(saludo);
    }
}
