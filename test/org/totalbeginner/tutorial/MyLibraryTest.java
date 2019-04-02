package org.totalbeginner.tutorial;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;  
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import java.util.ArrayList;

//Sorts by method name
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MyLibraryTest {
    private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private MyLibrary ml;
	//test constructor
    @Test
    void test1() {
        MyLibrary ml = new MyLibrary("Test1");  //local var
        assertEquals("Test1",ml.name);
        assertTrue(ml.books  instanceof  ArrayList);
        assertTrue(ml.people  instanceof  ArrayList);
    }    
    public void setup() {
        b1 = new Book("Book1");
        b2 = new Book("Book2");
        p1 = new Person();
        p2 = new Person();
        p1.setName("Fred");
        p2.setName("Sue");
        ml = new  MyLibrary("Test");
    }
    void test2() {
        //creates test objects
        setup();
        assertEquals("Test",ml.name);
        //test initial size is 0
        assertEquals(0, ml.getBooks().size());
        //add
        ml.addBook(b1);    ml.addBook(b2);
        assertEquals(2, ml.getBooks().size());  assertEquals(0, ml.getBooks().indexOf(b1));
        assertEquals(1, ml.getBooks().indexOf(b2));
        ml.removeBook(b1);
        assertEquals(1, ml.getBooks().size());    assertEquals(0, ml.getBooks().indexOf(b2));
        ml.removeBook(b2);
        assertEquals(0, ml.getBooks().size());
    }
    void test3CheckOut() {
        //setup object 
        setup();
        ml.addBook(b1);
        ml.addBook(b2);       
        ml.addPerson(p1);
        ml.addPerson(p2);
        assertTrue("오류, 도서 b1 대출 실행 않됨",ml.checkOut(b1,p1));
        assertEquals("오류, 이름이 Fred가 아님","Fred",b1.getPerson().getName());
        assertFalse("오류, 도서 b1 이미 대출됨",ml.checkOut(b1,p2));

        assertTrue("오류, 도서 b1 반납 실패",ml.checkIn(b1));
        assertFalse("오류, 도서 b1 이미 반납됨",ml.checkIn(b1));
        assertFalse("오류, 도서 b2 대출된 적 없음",ml.checkIn(b2));
    }    
}
