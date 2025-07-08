package com.johncnstn.pattern.observer.impl;

import com.johncnstn.pattern.observer.Observer;

public class ObserverImpl implements Observer {

    @Override
    public void notify(String message) {
        System.out.println(message + " I've been notified!!");
    }

}
