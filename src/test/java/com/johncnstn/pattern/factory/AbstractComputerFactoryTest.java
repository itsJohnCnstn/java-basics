package com.johncnstn.pattern.factory;

import com.johncnstn.pattern.factory.model.LaptopComputer;
import com.johncnstn.pattern.factory.model.PCComputer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbstractComputerFactoryTest {

    @Test
    void buildComputer_shouldBuildAllCases() {
        var pc = AbstractComputerFactory.buildComputer("p");
        var laptop1 = AbstractComputerFactory.buildComputer("L");
        var laptop2 = AbstractComputerFactory.buildComputer("l");

        // To check multiple conditions in one test and see all the failures together instead of fail fast
        assertSoftly(softAssertions -> {
            assertInstanceOf(PCComputer.class, pc);
            assertInstanceOf(LaptopComputer.class, laptop1);
            assertInstanceOf(LaptopComputer.class, laptop2);
            assertNotEquals(laptop1, laptop2);

            /*
                assertThrows(IllegalArgumentException.class, () -> {
                    // code that should throw the exception
                    someMethodThatThrows();
                });
            */
            assertThrows(IllegalArgumentException.class, () -> {
                AbstractComputerFactory.buildComputer("wrong type");
            });
        });
    }

    @Test
    void buildComputer_shouldBuildPCComputer() {
        var pc = AbstractComputerFactory.buildComputer("p");
        assertInstanceOf(PCComputer.class, pc);
    }

    @Test
    void buildComputer_shouldBuildLaptopComputer() {
        var laptop = AbstractComputerFactory.buildComputer("L");
        assertInstanceOf(LaptopComputer.class, laptop);
    }

    @Test
    void buildComputer_shouldBuildDifferentInstancesForTheSameType() {
        var laptop1 = AbstractComputerFactory.buildComputer("L");
        var laptop2 = AbstractComputerFactory.buildComputer("l");

        assertSoftly(softAssertions -> {
            assertInstanceOf(LaptopComputer.class, laptop1);
            assertInstanceOf(LaptopComputer.class, laptop2);
            assertNotEquals(laptop1, laptop2);
        });
    }

    @Test
    void buildComputer_shouldThrowIfWrongType() {
        assertThrows(IllegalArgumentException.class, () -> {
            AbstractComputerFactory.buildComputer("wrong type");
        });
    }

}