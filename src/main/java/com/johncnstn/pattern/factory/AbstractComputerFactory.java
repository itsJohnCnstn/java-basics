package com.johncnstn.pattern.factory;

import com.johncnstn.pattern.factory.model.AbstractComputer;
import com.johncnstn.pattern.factory.model.LaptopComputer;
import com.johncnstn.pattern.factory.model.PCComputer;

public abstract class AbstractComputerFactory {

    //Best practice for abstract class
    private AbstractComputerFactory() {
    }

    public static AbstractComputer buildComputer(String type) {
        return switch (type.toLowerCase()) {
            case "p" -> new PCComputer();
            case "l" -> new LaptopComputer();
            default -> throw new IllegalArgumentException("No such computer type!!");
        };
    }

}
