package dad.bindings;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Sample {

    public static void main(String[] args) {


        DoubleProperty a = new SimpleDoubleProperty(20);
        DoubleProperty b = new SimpleDoubleProperty(10);

        b.addListener((observable, oldValue, newValue) -> {
            System.out.println("antes " + oldValue + " y ahora " + newValue);
        });

        DoubleProperty c = new SimpleDoubleProperty();
        b.divide(c);

        c.bind(b.subtract(15).multiply(a));
        System.out.println("c = " + c.get());
    }
}
