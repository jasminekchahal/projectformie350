package com.restaurant.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reservation_cancelled")
public class Cancelled_Reservation extends Reservation{

    @NotNull
    private Date date_cancelled;

    public Cancelled_Reservation(String reservation_id, Customer customer, int guest_size, Date date_time, Date date_cancelled)
    {
        super(reservation_id, customer, guest_size, date_time);
        this.date_cancelled = date_cancelled;
    }
}
