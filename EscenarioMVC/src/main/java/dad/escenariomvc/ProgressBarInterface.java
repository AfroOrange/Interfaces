package dad.escenariomvc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgressBarInterface implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private Label valueLabel;

    @FXML
    private ProgressBar progressBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic here, such as setting default values
        progressBar.setProgress(0.5); // Example of setting initial progress
        valueLabel.setText("50%");
    }

    private void setProgress(double v) {
    }

    public VBox getRoot() {
        return root;
    }
}
