package com.restaurant.controller.exceptions;


public class ServerNotFoundException extends RuntimeException
{
    public ServerNotFoundException(long id)
    {
        super("Could not find Server " + id);
    }
}
