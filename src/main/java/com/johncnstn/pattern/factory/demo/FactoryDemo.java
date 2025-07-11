package com.johncnstn.pattern.factory.demo;

import com.johncnstn.pattern.factory.AbstractComputerFactory;
import com.johncnstn.pattern.factory.model.AbstractComputer;

import java.util.Set;

public class FactoryDemo {

    public static void main(String[] args) {
        var pc1 = AbstractComputerFactory.buildComputer("p");
        var l1 = AbstractComputerFactory.buildComputer("L");
        var l2 = AbstractComputerFactory.buildComputer("l");

        //Instances are different
        Set.of(pc1, l1, l2).forEach(AbstractComputer::turnOn);
        AbstractComputerFactory.buildComputer("IPHoNee?");
    }

}
