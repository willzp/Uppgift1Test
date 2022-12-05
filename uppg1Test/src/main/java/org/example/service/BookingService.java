package org.example.service;

public class BookingService {

    private PaymentService paymentService;
    private Library roomService;




    public String LoanBook(BookingRequest bookingRequest){
        paymentService.pay(bookingRequest.getBook().getPrice());
        if(bookingRequest.getBook().isBorrowed() == false){
            bookingRequest.getBook().setBorrowed(true);
            return "book is now borrowed";
        }
        else return "book is already borrowed";




    }


    public BookingService( PaymentService paymentService, Library roomService) {
        this.paymentService = paymentService;
        this.roomService = roomService;
    }


    public PaymentService getPaymentService() {
        return paymentService;
    }

    public Library getRoomService() {
        return roomService;
    }
}
