package com.johncnstn.pattern.factory.model;

public abstract class AbstractComputer {

    public static final String TURN_ON_PREFIX = "Starting.. ";

    public abstract void turnOn();

    public void turnOff() {
        System.out.println("will implement it later ;) ");
    }

}
