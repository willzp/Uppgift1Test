package org.example.service;

public class BookingRequest {

    private Book book;

    public BookingRequest(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
