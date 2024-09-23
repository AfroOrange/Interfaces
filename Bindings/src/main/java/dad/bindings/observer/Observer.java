package dad.bindings.observer;

public interface Observer<T> {

    void notify(T value);

    class StringObservable extends Observable<String> {

        private String value;

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
