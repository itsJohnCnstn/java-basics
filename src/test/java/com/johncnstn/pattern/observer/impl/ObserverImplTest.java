package com.johncnstn.pattern.observer.impl;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ObserverImplTest {

    @Test
    void notify_shouldPrintExpectedMessage() {
        //Given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //When
        ObserverImpl observer = new ObserverImpl();
        observer.notify("Observer1");

        //Then
        String output = out.toString();
        assertTrue(output.contains("Observer1 I've been notified!!"));
    }

}
