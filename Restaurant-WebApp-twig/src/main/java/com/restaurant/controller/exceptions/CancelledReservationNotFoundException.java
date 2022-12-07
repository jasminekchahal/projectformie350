package com.restaurant.controller.exceptions;

public class CancelledReservationNotFoundException extends RuntimeException{

    public CancelledReservationNotFoundException(String reservation_id)
    {
        super("Could not find Cancelled Reservation " + reservation_id );
    }
}
