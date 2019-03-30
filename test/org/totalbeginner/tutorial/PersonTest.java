package org.totalbeginner.tutorial;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PersonTest {
    @Test
    void testPerson() {
        Person  p1 = new Person();
        assertEquals("unknown name", p1.getName());
        assertEquals(3, p1.getMaximumBooks()); 	    }
    @Test
    void testSetName() {
        Person  p2 = new Person();
        p2.setName("Fred");
        assertEquals("Fred", p2.getName()); 	    }
    @Test
    void testSetMaxmimumBooks() {
        Person  p3 = new Person();
        p3.setMaxmimumBooks(3);
        assertEquals(3, p3.getMaximumBooks()); 	    }
}
