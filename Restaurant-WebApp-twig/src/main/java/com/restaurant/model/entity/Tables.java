package com.restaurant.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tables")
public class Tables
{
    @Id
    @NotNull
    private int id;
    @NotNull
    private int table_capacity;


    public Tables(int id, int table_capacity)
    {
        this.id = id;
        this.table_capacity = table_capacity;

    }

}

