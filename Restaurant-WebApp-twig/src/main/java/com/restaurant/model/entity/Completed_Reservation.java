package com.restaurant.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reservation_completed")
public class Completed_Reservation extends Reservation{

    @ManyToOne
    @JoinColumn(name = "serverId")
    @NotNull
    private Server server;

    @OneToOne
    @JoinColumn(name = "tableId")
    @NotNull
    private Tables tables;
    @NotNull
    private Date completed_time;

    @NotNull
    @OneToOne
    @JoinColumn(name = "reservationId")
    private CustomerRating customerRating;


    public Completed_Reservation(String reservation_id,Customer customer, int guest_size, Date date_time,Server server, Tables tables, Date completed_time, CustomerRating customerRating)
    {
        super(reservation_id, customer, guest_size, date_time);
        this.server = server;
        this.tables = tables;
        this.completed_time = completed_time;
        this.customerRating = customerRating;
    }
}
