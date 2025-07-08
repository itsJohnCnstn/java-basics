package com.johncnstn.pattern.observer.impl;

import com.johncnstn.pattern.observer.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ObservableImplTest {

    private ObservableImpl observable;

    @BeforeEach
    void setUp() {
        observable = new ObservableImpl();
    }

    @Test
    void addObserver_shouldAddObserver() {
        Observer observer = mock(ObserverImpl.class);
        observable.addObserver(observer);
        /*
            real object, not a mock
            verify(observable).addObserver(observer); -> won't work!
         */
        assertFalse(observable.observers.isEmpty());
    }

    @Test
    void removeObserver_shouldRemoveObserver() {
        Observer observer = mock(ObserverImpl.class);
        observable.addObserver(observer);
        observable.removeObserver(observer);
        assertTrue(observable.observers.isEmpty());
    }

    @Test
    void notifyObservers_shouldNotifyAll() {
        //Given
        Observer observer1 = mock(ObserverImpl.class);
        Observer observer2 = mock(ObserverImpl.class);
        observable.addObserver(observer1);
        observable.addObserver(observer2);

        //When
        /*
            no need, because
            doNothing().when(observer1).notify(anyString());
            doNothing().when(observer2).notify(anyString());
         */
        observable.notifyObservers();

        //Then
        verify(observer1, times(1)).notify(anyString());
        verify(observer2, times(1)).notify(anyString());
    }

}