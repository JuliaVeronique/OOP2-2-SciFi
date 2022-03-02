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

    public void notifyObservers() {
        this.notifyObservers(null);
    }

    public void notifyObservers(Object arg) {
        this.observers.forEach(observer -> observer.update(this, arg));
    }

    public abstract String getIdentity();

}

//    This specific variation of an Observable also has one extra method; getIdentity(),
//    which returns a String giving something about the identity.
//    It’s an abstract method, all subclasses will implement it as they see fit.

//    All Bodies, Species, Organizations and News (and their subclasses) need to be observable.
//    The Universe, Persons and Organizations need to be observers.
//    If an attribute of an observable object changes this needs to lead to a message to all the observers.
//    This is also true for nested situations; if an attribute of a Planet changes,
//    the Star needs to be informed, which informs the Universe.

/*
class CricketData implements Subject
{
    int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList;

    public CricketData() {
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers()
    {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(runs,wickets,overs);
        }
    }

    // get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }

    // get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }

    // get latest overs from stadium
    private float getLatestOvers()
    {
        // return 90 for simplicity
        return (float)10.2;
    }

    // This method is used update displays
    // when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObservers();
    }
}

 */

// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from CricketData

/*
class AverageScoreDisplay implements Observer
{
    private float runRate;
    private int predictedScore;

    public void update(int runs, int wickets,
                       float overs)
    {
        this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }

    public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                + "Run Rate: " + runRate +
                "\nPredictedScore: " +
                predictedScore);
    }
}

class CurrentScoreDisplay implements Observer
{
    private int runs, wickets;
    private float overs;

    public void update(int runs, int wickets,
                       float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs );
    }
}

 */