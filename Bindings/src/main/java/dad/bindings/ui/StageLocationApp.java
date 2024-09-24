package dad.bindings.ui;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class StageLocationApp extends Application {

    private Label coordsLabel;
    private Label sizeLabel;

    @Override
    public void start(Stage stage) throws Exception {

        StringBinding width = stage.widthProperty().asString();
        StringBinding height = stage.heightProperty().asString();

        coordsLabel = new Label();
        sizeLabel = new Label();

        coordsLabel.textProperty().bind(Bindings.concat("Pos: ", stage.xProperty(), " , ", stage.yProperty()));

        sizeLabel.textProperty().bind(Bindings.concat("Size: ", width, " , ", height));

        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(coordsLabel, sizeLabel);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Size and Location");
        stage.show();

    }
}
