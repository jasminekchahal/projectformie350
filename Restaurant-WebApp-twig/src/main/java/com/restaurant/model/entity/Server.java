package com.restaurant.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "server")
public class Server
{
    @Id
    @NotNull
    private long id;

    @NotEmpty
    private String name;

    @NotNull
    private int availability;

    @NotNull
    private int serving_capacity;

    public Server(long id, String name, int availability, int serving_capacity)
    {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.serving_capacity = serving_capacity;
    }
}
