package org.totalbeginner.tutorial;

public class Book {

	public String title;
	public String author;
	private Person person;

	public Book(String string) {
        this.title = string;
        this.author = "unknown author";
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setPerson(Person p2) {
        this.person = p2;
	}
	public Person getPerson() {
		return this.person;
	}
    public  String  toString() {
        String available;                                                                               // 변수 available 설정
        if (this.getPerson() == null) {                      // 도서 객체의 getPerson() ==null 이면
            available = "Available";                         // 대출가능  대치
        } else {                                             // null 이 아니면, 대출되었으면 
            available = "Checked out to " + this.getPerson().getName();  // available에 대출자 이름 설정
        }    
        return  this.getTitle() + " by " + this.getAuthor() + "; " + available;    // 전체 문구 반환
    }
}

