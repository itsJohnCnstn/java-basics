package com.johncnstn.pattern.observer.demo;

import com.johncnstn.pattern.observer.impl.ObservableImpl;
import com.johncnstn.pattern.observer.impl.ObserverImpl;

public class ObserverDemo {
    public static void main(String[] args) {
        var observable = new ObservableImpl();

        var observer1 = new ObserverImpl();
        var observer2 = new ObserverImpl();
        var observer3 = new ObserverImpl();

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.notifyObservers();
    }
}