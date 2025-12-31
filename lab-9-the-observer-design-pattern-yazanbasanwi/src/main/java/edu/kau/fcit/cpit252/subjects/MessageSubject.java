package edu.kau.fcit.cpit252.subjects;

import java.util.ArrayList;
import java.util.List;

import edu.kau.fcit.cpit252.observers.Observer;

public class MessageSubject implements Subject {
    List<Observer> observers;

    public MessageSubject() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void subscribe(Observer o) {
this.observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
this.observers.remove(o);
    }

    @Override
    public void notifyUpdate(String m) {
for (Observer o : observers) {
    o.update(m);
}
    }

}
