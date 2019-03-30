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
        p3.setMaximumBooks(3);
        assertEquals(3, p3.getMaximumBooks()); 	    }
    @Test
    void testToString() {
    	Person p4 = new Person();
    	p4.setName("Fred Flintstone");
    	p4.setMaximumBooks(7);
    	String  testString ="Fred Flintstone (7 books)";
        assertEquals(testString,p4.toString()); 	    }
}

