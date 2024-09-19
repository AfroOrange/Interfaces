package dad.recogida.datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class RecogidaDatos extends Application {

    private TextField nombrePersona;
    private Label etiquetaNombre;
    private TextField apellidoPersona;
    private Label etiquetaApellido;
    private TextField edadPersona;
    private Label etiquetaEdad;
    private Button botonGuardar;
    private Button botonLimpiar;

    @Override
    public void start(Stage stage) throws Exception {

        nombrePersona = new TextField();
        etiquetaNombre = new Label();
        nombrePersona.setPrefColumnCount(20);
        etiquetaNombre.setText("Nombre: ");
        nombrePersona.setPromptText("Introduce el nombre de la persona");

        apellidoPersona = new TextField();
        etiquetaApellido = new Label();
        apellidoPersona.setPrefColumnCount(20);
        etiquetaApellido.setText("Apellido: ");
        apellidoPersona.setPromptText("Introduce el apellido de la persona");

        edadPersona = new TextField();
        etiquetaEdad = new Label();
        edadPersona.setPrefColumnCount(3);
        etiquetaEdad.setText("Edad: ");
        edadPersona.setPromptText("Introduce la edad de la persona");

        // Hbox para nombre
        HBox hboxNombre = new HBox(10);
        hboxNombre.getChildren().addAll(etiquetaNombre, nombrePersona);

        //Hbox para apellido
        HBox hboxApellido = new HBox(10);
        hboxApellido.getChildren().addAll(etiquetaApellido, apellidoPersona);

        // Hbox para edad
        HBox hboxEdad = new HBox(10);
        hboxEdad.setPrefSize(300,300);
        hboxEdad.getChildren().addAll(etiquetaEdad, edadPersona);

        // Botones para guardar y limpiar
        botonGuardar = new Button("Guardar");
        botonGuardar.setDefaultButton(true);
        botonGuardar.setOnAction(_ -> {
            try {
                onGuardarAction();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // botón para limpiar campos
        botonLimpiar = new Button("Limpiar");
        botonLimpiar.setOnAction(e -> onLimpiarCampos(e));

        HBox hboxBotones = new HBox(10);
        hboxBotones.setAlignment(Pos.CENTER);
        hboxBotones.getChildren().addAll(botonGuardar, botonLimpiar);

        // Vbox para integrar los cuadros de textos creados
        VBox root = new VBox();
        root.setStyle("-fx-background-color: f5d376");
        root.setPadding(new Insets(50));
        root.setSpacing(10);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(hboxNombre, hboxApellido, hboxEdad, hboxBotones);


        // Escena
        Scene scene = new Scene(root, 400, 200);
        stage.setTitle("Recogida de Datos");
        stage.setScene(scene);
        stage.show();

    }

    private void onGuardarAction() throws IOException {
        Persona p = new Persona();
        p.setNombre(nombrePersona.getText()); // Get the text value
        p.setApellidos(apellidoPersona.getText()); // Get the text value
        p.setEdad(Integer.valueOf(edadPersona.getText())); // Get the text value

        // Convertir a JSON usando Gson
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(p);

        // Guardar en archivo JSON
        File jsonFile = new File("RecogidaDatos.json");
        try {
            Files.writeString(jsonFile.toPath(), json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        nombrePersona.clear();
        apellidoPersona.clear();
        edadPersona.clear();
    }

    private void onLimpiarCampos(ActionEvent e) {
        nombrePersona.clear();
        apellidoPersona.clear();
        edadPersona.clear();
    }
}
