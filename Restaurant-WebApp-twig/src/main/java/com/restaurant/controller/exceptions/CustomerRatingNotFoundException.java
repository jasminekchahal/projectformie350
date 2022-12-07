package com.restaurant.controller.exceptions;

public class CustomerRatingNotFoundException extends RuntimeException{
    public CustomerRatingNotFoundException(String number)
    {
        super("Could not find customer review with Reservation ID: " + number);
    }
}
