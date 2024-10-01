package dad.escenariomvc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    private IntegerProperty value = new SimpleIntegerProperty();
    private IntegerProperty aux = new SimpleIntegerProperty();

    @FXML
    private VBox root;

    @FXML
    private Label valueLabel;

    @FXML
    private TextField valueText;

    public ModificarController() {
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
        // Bind TextField to aux with NumberStringConverter
        valueText.textProperty().bindBidirectional(aux, new NumberStringConverter());

        // Bind Label to the value property, converting IntegerProperty to String
        valueLabel.textProperty().bind(value.asString());

        // Optional: bind aux and value if they represent the same concept
        aux.bindBidirectional(value);
    }

    public VBox getRoot() {
        return root;
    }

    @FXML
    private void onSetAction(ActionEvent e) {
        System.out.println("Establecer");
        try {
            int intValue = Integer.parseInt(valueText.getText());
            setValue(intValue);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input: " + valueText.getText());
        }
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public void setValue(int newValue) {
        value.set(newValue);
    }

    public int getValue() {
        return value.get();
    }

    @FXML
    private void onIncrementAction(ActionEvent event) {
        System.out.println("Incrementar");
        setValue(getValue() + 1);  // Increment value by 1
    }

    @FXML
    private void onDecrementAction(ActionEvent event) {
        System.out.println("Disminuir");
        setValue(getValue() - 1);  // Decrement value by 1
    }
}
