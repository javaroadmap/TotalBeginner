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
    public  boolean  checkOut(Book b1, Person p1) {
//      b1.setPerson(p1);         //book1에 p1객체를 입력
      int  booksOut = this.getBooksForPerson(p1).size(); // p1의 도서 대출총량 계산
      if ( (b1.getPerson() == null) // b1객체의 getPerson()실행결과가 null이면 (즉Person이 할당되어있지 않으면)
                                    //  도서 b1이 대여 되지 않았으면
         &&  (booksOut < p1.getMaximumBooks()) )  // p1의 총대출총량<도서대출제한수  
      {                                              
          b1.setPerson(p1);               //  도서 b1을 사람 p1에게 대여
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
    public ArrayList<Book> getBooksForPerson(Person p1) {
	  ArrayList<Book> result = new ArrayList<Book>();
	  for (Book aBook : this.getBooks()) {
        if ((aBook.getPerson() != null) && 
//				(aBook.getPerson().getName().equals(p1.getName())))
				(aBook.getPerson().getName()==(p1.getName())))
		{
				result.add(aBook);
		}
      }
	  return result;
    }
	public ArrayList<Book> getAvailableBooks() {
      ArrayList<Book> result = new ArrayList<Book>();
	  for (Book aBook : this.getBooks()) {
	    if (aBook.getPerson() == null)
	    {
			result.add(aBook);
		}
	  }
	  return result;
	}
	public ArrayList<Book> getUnavailableBooks() {
	  ArrayList<Book> result = new ArrayList<Book>();
	  for (Book aBook : this.getBooks()) {
		if ((aBook.getPerson() != null))
		{
			result.add(aBook);
		}
	  }
	  return result;
	}
	public  String  toString() {
	    return  this.getName() + ": " + 
	         this.getBooks().size() + " books; " + 
	         this.getPeople().size() + " people.";
	}
	public static void main(String[] args) {
		// create a new MyLibrary
		MyLibrary testLibrary = new MyLibrary("Test Drive Librry");
		Book b1 = new Book("War And Peace");
		Book b2 = new Book("Great Expectations");
		b1.setAuthor("Tolstoy");
		b2.setAuthor("Dickens");
		Person jim = new Person();
		Person sue = new Person();
		jim.setName("Jim");
		sue.setName("Sue");
        testLibrary.addBook(b1); 
        testLibrary.addBook(b2);
        testLibrary.addPerson(jim); 
        testLibrary.addPerson(sue);
		System.out.println("Just created new library");
		testLibrary.printStatus();
		System.out.println("Check out War And Peace to sue");
		testLibrary.checkOut(b1, sue);
		testLibrary.printStatus();
		System.out.println("Do some more stuff");
		testLibrary.checkIn(b1);
		testLibrary.checkOut(b2, jim);
		testLibrary.printStatus();
	}
	private void printStatus() {
		System.out.println("Status Report of MyLibrary\n" + this.toString());
		for (Book thisBook : this.getBooks()) {
			System.out.println(thisBook); 
			//System.out.println(thisBook.toString());
		}
		for (Person p : this.getPeople()) {
			int count = this.getBooksForPerson(p).size();
			System.out.println(p + " (has " + count + " of my books)");
		}
		System.out.println("Books Available: "
		      + this.getAvailableBooks().size());
		System.out.println("--- End of Status Report ---");
	}
}




