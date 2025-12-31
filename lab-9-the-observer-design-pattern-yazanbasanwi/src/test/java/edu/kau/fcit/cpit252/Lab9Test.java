package edu.kau.fcit.cpit252;

import edu.kau.fcit.cpit252.observers.Observer;
import edu.kau.fcit.cpit252.subjects.Subject;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class Lab9Test {
    /**
     * There should an abstract class called Observer
     * This abstract class should have methods called getRecipient, setRecipient
     * and an abstract method called update. It should have an instance variable called recipient
     */

    @Test
    public void testObserverAbstractClass() {
        assertTrue(Modifier.isAbstract(Observer.class.getModifiers()));
        assertEquals(3, Observer.class.getDeclaredMethods().length);
        Method[] methods = Observer.class.getDeclaredMethods();
        int abstractMethodCount = 0;
        for (Method m : methods) {
            if (Modifier.isAbstract(m.getModifiers())) {
                abstractMethodCount++;
                assertEquals("update", m.getName());
            }
        }
        assertEquals(1, abstractMethodCount);
    }

    @Test
    public void testSubjectInterface() {
        assertTrue(Modifier.isInterface(Subject.class.getModifiers()));
        assertEquals(3, Subject.class.getDeclaredMethods().length);
        Method[] methods = Subject.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName() == "notifyUpdate") {
                assertEquals(1, m.getParameterCount());
                assertEquals(String.class.getTypeName(), m.getParameterTypes()[0].getName());
            }
            else if (m.getName() == "subscribe" || m.getName() == "unsubscribe") {
                assertEquals(1, m.getParameterCount());
                assertEquals(Observer.class.getTypeName(), m.getParameterTypes()[0].getName());
            }
            else{
                // You should not have any additional methods
                assertFalse(true);
            }
        }
    }

    public void testMessageSubject(){

    }

    public void testEmailObserver(){

    }

    public void testFacebookObserver(){

    }

    public void testWhatsappObserver(){

    }

    public void testSendEmail(){

    }
}
