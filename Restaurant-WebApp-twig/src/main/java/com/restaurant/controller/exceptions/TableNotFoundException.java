package com.restaurant.controller.exceptions;

public class TableNotFoundException extends RuntimeException{
    public TableNotFoundException(int id)
    {
        super("Could not find table " + id);
    }
}