package com.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApp
{
    private static Logger LOG = LoggerFactory
            .getLogger(RestaurantApp.class);

    public static void main(String[] args)
    {
        SpringApplication.run(RestaurantApp.class, args);
        LOG.info("APPLICATION IS RUNNING");
    }
}
