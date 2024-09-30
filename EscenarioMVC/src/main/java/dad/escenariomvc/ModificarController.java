package dad.escenariomvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    // View con los atributos creados en SceneBuilder

    @FXML
    private VBox root;

    @FXML
    private TextField valueText;

    // instanciar los siguientes atributos
    ModificarController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ModificarView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public VBox getRoot() {
        return root;
    }

    @FXML
    private void onSetAction(ActionEvent e) {
        System.out.println("Establecer");
    }

    @FXML
    private void onIncrementAction(ActionEvent event) {
        System.out.println("Incrementar");
    }

    @FXML
    private void onDecrementAction(ActionEvent event) {
        System.out.println("Disminuir");
    }
}
