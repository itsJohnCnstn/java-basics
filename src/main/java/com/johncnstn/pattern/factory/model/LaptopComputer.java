package com.johncnstn.pattern.factory.model;

public class LaptopComputer extends AbstractComputer {

    @Override
    public void turnOn() {
        System.out.println(TURN_ON_PREFIX + "Laptop!");
    }

}
