package com.restaurant.controller.Dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter

public class ReservationDto {

    private String phone_number;
    private int guest_size;
    private Date date_time;

}
