package org.totalbeginner.tutorial;
import java.util.ArrayList;
import java.util.function.Supplier;
public class MyLibrary {
    public String name;
	public ArrayList<Book> books;
    public ArrayList<Person> people;
    public MyLibrary(String  name) {
        this.name = name;
        books = new  ArrayList<Book>();
        people = new  ArrayList<Person>();
    }
    public String getName() {
		return name;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public ArrayList<Person> getPeople() {
		return people;
	}
	public void addBook(Book b1) {
        this.books.add(b1);
    }
	public void removeBook(Book b1) {
		this.books.remove(b1);
	}
	public void addPerson(Person p1) {
        this.people.add(p1);
    }
	public void removePerson(Person p1) {
		this.people.remove(p1);
	}
    public boolean  checkOut(Book b1, Person p1) {
//      b1.setPerson(p1);         // book1에 p1객체를 입력
      if (b1.getPerson() == null) { // b1객체의 getPerson()실행결과가 null이면 
    	                            // (즉Person이 할당되어있지 않으면)
                                    //  도서 b1이 대여 되지 않았으면
          b1.setPerson(p1);         //  도서 b1을 사람 p1에게 대여
          return true;
      } 
      else {
          return false;
      }
  }
    public boolean  checkIn(Book b1) {
//      b1.setPerson(null);         //book1에 null 객체를 입력
      if (b1.getPerson() != null) { // b1객체의 getPerson()실행결과가 null이 아니면 
    	                            // (즉 Person이 할당되어있으면)
                                    // 도서 b1이 대여된 책이면
          b1.setPerson(null);       // 도서 b1을 대여가능(null) 책으로 설정
          return true;
      } 
      else {
          return false;
      }
  }
}




