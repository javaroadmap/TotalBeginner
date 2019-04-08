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
    @Test
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
    @Test
    void test3() {
        //setup object 
        setup();
        addItems();
        assertTrue("오류, 도서 b1 대출 실행 않됨",ml.checkOut(b1,p1));
        assertEquals("Fred",b1.getPerson().getName());
        assertFalse("오류, 도서 b1 이미 대출됨",ml.checkOut(b1,p2));

        assertTrue("오류, 도서 b1 반납 실패",ml.checkIn(b1));
        assertFalse("오류, 도서 b1 이미 반납됨",ml.checkIn(b1));
        assertFalse("오류, 도서 b2 대출된 적 없음",ml.checkIn(b2));
        //additional test for maximumbooks
        setup();
        p1.setMaximumBooks(1);
        addItems();
        assertTrue("오류, 도서 b2 대출 실행 않됨",ml.checkOut(b2,p1));
        assertFalse("오류, 도서 b1이 p1에 대여되면 않됨",ml.checkOut(b1,p1));
    }
	private void addItems() {
		ml.addBook(b1);
        ml.addBook(b2);       
        ml.addPerson(p1);
        ml.addPerson(p2);
	}  
    @Test
    void test4() {
        //setup object 
        setup();
        addItems();
        ml.checkOut(b1,p1);
        assertEquals(1,ml.getBooksForPerson(p1).size()); 
        ArrayList<Book>  testBooks = ml.getBooksForPerson(p1);
        assertEquals(1,testBooks.size());
        assertEquals(0,testBooks.indexOf(b1));
        ml.checkOut(b2,p1);
        testBooks = ml.getBooksForPerson(p1);
        assertEquals(2,testBooks.size());
        assertEquals(1,testBooks.indexOf(b2));
    }
    @Test
    void  test5() {
        //setup object 
        setup();
        addItems();
        ArrayList<Book> testBooks = ml.getAvailableBooks(); // 현재 가용도서목록가져오기
        assertEquals(2,testBooks.size());                   // 가용도서수 = 2
        assertEquals(1,testBooks.indexOf(b2));              // b2도서의 인덱스 = 1 
 
        ml.checkOut(b1,p1);                                 // 도서 b1을 사용자 p1 에 대출 
        testBooks = ml.getAvailableBooks();                 // 가용도서목록
        assertEquals(1,testBooks.size());                   // 가용도서수 = 1
        assertEquals(0,testBooks.indexOf(b2));              // 도서 b1의 인덱스 = 0 

        ml.checkOut(b2,p1);                                 // 도서 b2를 사용자 p1 에 대출 
        testBooks = ml.getAvailableBooks();                 // 가용도서목록
        assertEquals(0,testBooks.size());                   // 가용도서수 = 0
    }    
    @Test
    void  test6() {
        //setup object 
        setup();
        addItems();

        ArrayList<Book> testBooks = ml.getUnavailableBooks(); // 현재 대출 도서 목록 가져오기
        assertEquals(0,testBooks.size());                      // 대출도서수 = 0 테스트
        ml.checkOut(b1,p1);                                    // 도서 b1을 사용자 p1 에 대출 
        testBooks = ml.getUnavailableBooks();                  // 대출도서 목록
        assertEquals(1,testBooks.size());                      // 대출도서수 = 1 테스트
        assertEquals(0,testBooks.indexOf(b1));                 // 도서 b1의 인덱스 = 0 테스트 
        ml.checkOut(b2,p1);                                    // 도서 b2를 사용자 p2 에 대출 
        testBooks = ml.getUnavailableBooks();                  //  대출도서 목록
        assertEquals(2,testBooks.size());                      // 대출도서수 = 2 테스트
        assertEquals(1,testBooks.indexOf(b2));                 // 도서 b2의 인덱스 = 1 테스트
    }
    @Test
    void  test7() {
        //setup object 
        setup();
        addItems();
        assertEquals("Test: 2 books; 2 people.",ml.toString()); // Test: 2 books, 2 people. 테스트
    }    
} 


