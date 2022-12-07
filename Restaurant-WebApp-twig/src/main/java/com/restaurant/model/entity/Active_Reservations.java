package com.restaurant.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reservation_active")
public class Active_Reservations extends Reservation{

    public Active_Reservations(String reservation_id, Customer customer, int guest_size, Date date_time)
    {
        super(reservation_id, customer, guest_size, date_time);

    }
}
