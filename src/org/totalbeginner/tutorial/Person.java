package org.totalbeginner.tutorial;
public  class  Person {
    //fields
    private  String  name;  //name of person
    private  int  maxmimumBooks;   //most books the person can check out
    //constructors
    public  Person() {
        name = "unknown name";
        maxmimumBooks = 3; }
    //methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxmimumBooks() {
		return maxmimumBooks;
	}
	public void setMaxmimumBooks(int maxmimumBooks) {
		this.maxmimumBooks = maxmimumBooks;
	}   
}
