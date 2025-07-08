package com.johncnstn.pattern.observer.impl;

import com.johncnstn.pattern.observer.Observable;
import com.johncnstn.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    public List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Publisher: " + this + " is notifying an observer..");
            observer.notify(observer.toString());
        }
    }

}
