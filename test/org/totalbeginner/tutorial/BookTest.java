package org.totalbeginner.tutorial;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class BookTest {
	@Test
	void test() {
        Book  b1 = new Book("Great Book");
        assertEquals("Great Book", b1.title);
        assertEquals("unknown author", b1.author); 
	}
	@Test
	void testGetPerson() {
        Book  b2 = new Book("War and Peace");
        Person p2 = new Person();
        p2.setName("Elvis");
        //method to say that the book is loaned to this person
        b2.setPerson(p2);
        //get the name of the person who has the book
        Person testPerson = b2.getPerson();
        String testName = testPerson.getName();
        assertEquals("Elvis", testName); 
	}
}
