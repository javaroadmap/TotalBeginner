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
}
