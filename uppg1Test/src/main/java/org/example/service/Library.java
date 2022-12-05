package org.example.service;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();


    Book book1 = new Book("man","william","2005","action", 20);
    Book book2 = new Book("woman","john","2020","fantasy", 20);
    Book book3 = new Book("santa","sofia","2022","fiction", 20);
    Book book4 = new Book("war","manuel","2009","comedy", 20);
    Book book5 = new Book("ice","simon","2012","horror", 20);





    public ArrayList<Book> getAvailableBooks() {
        return books;
    }

    public void addBooks(){
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

    }
    public Book addOneBook(Book book){
        books.add(book);
        return book;
    }



    public Book getBookByAuthor(String author){

        for(int i = 0; i < books.size(); i++){

            Book b = books.get(i);
            if(b.getAuthor() == author){
                return b;
            }
        }
    return null;
    }
    public Book getBookByTitle(String title){
        for(int i = 0; i < books.size(); i++){

            Book b = books.get(i);
            if(b.getTitle() == title){
                return b;
            }
        }
        return null;
    }
    public Book getBookByDate(String date){
        for(int i = 0; i < books.size(); i++){

            Book b = books.get(i);
            if(b.getDate() == date){
                return b;
            }
        }
        return null;
    }
    public Book getBookByStars(int stars){
        for(int i = 0; i < books.size(); i++){

            Book b = books.get(i);
            if(b.getStars() == stars){
                return b;
            }
        }
        return null;
    }
    public Book getBookByGenre(String genre){
        for(int i = 0; i < books.size(); i++){

            Book b = books.get(i);
            if(b.getGenre() == genre){
                return b;
            }
        }
      return null;
    }


    public int getBookCount(){
        return books.size();
    }

}
