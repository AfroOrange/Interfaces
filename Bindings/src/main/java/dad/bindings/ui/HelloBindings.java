package dad.bindings.ui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloBindings extends Application {

    private TextField textFieldName;
    private Label greetingLabel;
    private CheckBox hasNameCheck;

    @Override
    public void start(Stage stage) throws Exception {

        textFieldName = new TextField();
        textFieldName.setPromptText("Introduce el nombre");

        greetingLabel = new Label();
        hasNameCheck = new CheckBox("Hay nombre");

        VBox root = new VBox();
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(textFieldName, greetingLabel, hasNameCheck);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Greetings");
        stage.setScene(scene);
        stage.show();

        // Bindings

        greetingLabel.textProperty().
                bind(Bindings.concat(
                        "Wenas ", Bindings.when(textFieldName.textProperty()
                                .isEmpty())
                                .then("a todo el mundo")
                                .otherwise(textFieldName.textProperty())
                        )
                );

        // las propiedades del checkbox son selected
        hasNameCheck.selectedProperty().bind(textFieldName.textProperty().isNotEmpty());
    }
}
