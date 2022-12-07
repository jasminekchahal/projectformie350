package com.restaurant.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @NotEmpty
    private String reservation_id;


    @ManyToOne
    @JoinColumn(name = "customerNumber")
    @NotNull
   // @JsonIgnoreProperties({"email"})
    private Customer customer;
    @NotNull
    private int guest_size;

    @NotNull
    private Date date_time;

    public Reservation(String reservation_id, Customer customer, int guest_size, Date date_time)
    {
        this.reservation_id = reservation_id;
        this.customer = customer;
        this.guest_size = guest_size;
        this.date_time = date_time;
    }

}
