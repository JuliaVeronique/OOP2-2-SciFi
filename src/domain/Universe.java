package domain;

import java.util.ArrayList;
import java.util.List;

public class Universe implements Observer {
    private static Universe instance = new Universe();
    private List<Body> bodies = new ArrayList<>();
    private Body body;

    private Universe() {
    }

    public static Universe getInstance() {
        return instance;
    }

    public void addBody(Body body) {
        this.body = body;
        body.addObserver(this);
        bodies.add(body);
    }

    @Override
    public String toString() {
        return "Universe{" +
                "bodies=" + bodies + bodies.size() +
                '}';
    }


    @Override
    public void update() {
        System.out.println(this.body.getIdentity());
    }

    @Override
    public void update(String arg) {
        System.out.println(arg + this.body.getIdentity());
    }
}
