package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookingServiceTest {

    private Library library;

    private PaymentService paymentService;
    private BookingService bookingService;



    @BeforeEach
    public void setup(){
        library = mock(Library.class);
        paymentService = mock(PaymentService.class);
        bookingService = new BookingService( paymentService, library);
    }


    @Test void TestGetBookByAuthor(){
        Library library = new Library();
        library.addBooks();
        Book actual = library.getBookByAuthor("william");
        String expected = "william";
        assertEquals(expected,actual.getAuthor());

    }
    @Test void TestLoanBook(){
        Book book = new Book("ice","simon","2012","horror", 20);
        BookingRequest bookingRequest = new BookingRequest(book);
        bookingService.LoanBook(bookingRequest);
        assertEquals(true,book.isBorrowed());


    }
    @Test void TestPaymentService(){
        PaymentService paymentService1 = new PaymentService();
       String actual = paymentService1.pay(150);
       String expected = "paid 150";
       assertEquals(expected,actual);

    }
    @Test void TestGetBookByTitle(){
        Library library = new Library();
        library.addBooks();
        Book actual = library.getBookByTitle("man");
        String expected = "man";
        assertEquals(expected,actual.getTitle());

    }
    @Test void TestGetBookByDate(){
        Library library = new Library();
        library.addBooks();
        Book actual = library.getBookByDate("2005");
        String expected = "2005";
        assertEquals(expected,actual.getDate());
    }
    @Test void TestGetBookByStars(){
        Library library = new Library();
        Book book = new Book("ice","simon","2012","horror", 20);
        book.setStars(4);
        library.addOneBook(book);
        book = library.getBookByStars(4);
        int expected = 4;
        assertEquals(expected, book.getStars());
    }
    @Test void TestGetBookByGenre(){
        Library library = new Library();
        library.addBooks();
        Book actual = library.getBookByGenre("action");
        String expected = "action";
        assertEquals(expected,actual.getGenre());

    }
    @Test void TestIfBookIsAlreadyLoaned(){
        Book book = new Book("ice","simon","2012","horror", 20);
        book.setBorrowed(true);
        BookingRequest bookingRequest = new BookingRequest(book);
        String actual = bookingService.LoanBook(bookingRequest);
        String expected = "book is already borrowed";
        assertEquals(expected, actual);


    }

    @Test void TestMethodTimes(){
        Book book = new Book("ice","simon","2012","horror", 20);
        book.setBorrowed(true);
        BookingRequest bookingRequest = new BookingRequest(book);
        bookingService.LoanBook(bookingRequest);
        verify(paymentService, times(1)).pay(anyInt());
    }
    @Test void TestWhen(){
        Book book = new Book("ice","simon","2012","horror", 20);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        when(library.getAvailableBooks()).thenReturn(books);
       assertEquals(1, library.getAvailableBooks().size());
    }
}