package com.restaurant.controller.exceptions;

public class CustomerNotFoundException extends RuntimeException
{
    public CustomerNotFoundException(String number)
    {
        super("Could not find customer with phone number: " + number);
    }
}
