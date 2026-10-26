package com.pluralsight;

public class Book {
    int id;
    String isbn;
    String title;
    String name;
    boolean isCheckedOut;

    public Book(){
        int id = 0;
        String isbn = "";
        String title = "";
        String name = "";
        boolean isCheckedOut = false;
    }

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public int id() {
        return id;
    }

    public String isbn() {
        return isbn;
    }

    public String title() {
        return title;
    }

    public String getName(){
        return name;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }


}
