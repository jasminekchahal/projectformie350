package com.restaurant.controller.exceptions;

public class CompletedReservationNotFoundException extends RuntimeException{

    public CompletedReservationNotFoundException(String reservation_id)
    {
        super("Could not find Completed Reservation " + reservation_id );
    }
}
