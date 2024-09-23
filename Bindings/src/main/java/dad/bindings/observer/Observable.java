package dad.bindings.observer;


import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    protected void notificar(T value) {
        this.observers.forEach(o -> o.notify(value));
    }
}
