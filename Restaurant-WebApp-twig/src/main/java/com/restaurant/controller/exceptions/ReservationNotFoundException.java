package com.restaurant.controller.exceptions;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String reservation_id)
    {
        super("Could not find Reservation " + reservation_id );
    }
}
