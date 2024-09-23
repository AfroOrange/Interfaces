package dad.bindings;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sample1 {
    public static void main(String[] args) {

        StringProperty nombre = new SimpleStringProperty();
        StringProperty apellidos = new SimpleStringProperty();
        StringProperty nombreCompleto = new SimpleStringProperty();

        nombreCompleto.bind(nombre.concat(" ").concat(apellidos));
        nombreCompleto.addListener((_, _, t1) -> {
                System.out.println("Nombre Completo " + t1);
        });

        nombre.set("Miguel");
        apellidos.set("Gómez");

    }
}
