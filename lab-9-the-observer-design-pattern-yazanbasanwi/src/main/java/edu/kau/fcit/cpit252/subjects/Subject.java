package edu.kau.fcit.cpit252.subjects;

import edu.kau.fcit.cpit252.observers.Observer;


public interface Subject{
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyUpdate(String m);
}
