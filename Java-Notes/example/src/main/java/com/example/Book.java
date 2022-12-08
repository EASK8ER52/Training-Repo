package com.example;

/*
 * There are many excellent 3rd party libraries that will handle converting jsons into java
 * objects and vice versa. HOWEVER, in order to make use of most of these libraries, many of them
 * require you to set up your class in a specific way: they require the Java bean design pattern
 */
public class Book
{
    private String title;
    private String author;
    private String genre;
    private int isbn;

    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
