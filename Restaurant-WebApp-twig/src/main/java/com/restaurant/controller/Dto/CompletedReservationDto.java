package com.restaurant.controller.Dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter

public class CompletedReservationDto {
    private String reservation_id;
    private Long server_id;
    private int table_id;
    private double rating;
}
