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
    @Test
    void  testToString() {
        Book  b2 = new  Book("War And Peace"); //b2 도서객체 (War And Peace) 생성
        Person  p2 = new  Person();            // p2 사용자 객체 생성
        p2.setName("Elvis");                   // p2 사용자 이름 Elvis 설정

        assertEquals("War And Peace by unknown author; Available",b2.toString()); 
                                               // War And Peace by unknown author; Available 인쇄 테스트
        b2.setPerson(p2);                      // 도서 b2를사용자 p2에 대여
        assertEquals("War And Peace by unknown author; Checked out to Elvis",b2.toString()); 
                                               // War And Peace by unknown author; Checked out to Elvis 인쇄 테스트
    }
}
