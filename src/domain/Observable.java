package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void notifyObserver(Observer o, String arg) {
        if (this.observers.contains(o)) o.update(arg);
    }
    public void notifyObserver(Observer o) {
        if (this.observers.contains(o)) o.update();
    }

    public void notifyObservers() {
        this.notifyObservers("no message\n");
    }

    public void notifyObservers(String arg) {
        this.observers.forEach(observer -> observer.update(arg));
    }

    public abstract String getIdentity();

}
