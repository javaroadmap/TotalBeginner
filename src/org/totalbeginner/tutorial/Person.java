package org.totalbeginner.tutorial;
public  class  Person {
    //fields
    private  String  name;  //name of person
    private  int  maximumBooks;   //most books the person can check out
    //constructors
    public  Person() {
        name = "unknown name";
        maximumBooks = 3; }
    //methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaximumBooks() {
		return maximumBooks;
	}
	public void setMaxmimumBooks(int maxmimumBooks) {
		this.maximumBooks = maxmimumBooks;
	}   
}
