package dad.escenariomvc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgressBarInterface implements Initializable {

    private IntegerProperty value = new SimpleIntegerProperty();

    @FXML
    private VBox root;

    @FXML
    private Label valueLabel;

    @FXML
    private ProgressBar valueProgress;

    public ProgressBarInterface() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProgressBarView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valueProgress.progressProperty().bind(value.divide(100.0));
        valueLabel.textProperty().bind(value.asString());

    }
    public IntegerProperty valueProperty() {
        return value;
    }


    public VBox getRoot() {
        return root;
    }
}
