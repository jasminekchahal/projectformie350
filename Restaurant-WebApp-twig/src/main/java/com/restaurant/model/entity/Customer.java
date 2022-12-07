package com.restaurant.model.entity;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @NotEmpty
    private String name;

    @Nullable
    private String email;
    @Id
    @NotEmpty
    private String number;
    public Customer(String name, String email, String number)
    {
        this.name = name;
        this.email = email;
        this.number = number;

    }
}
