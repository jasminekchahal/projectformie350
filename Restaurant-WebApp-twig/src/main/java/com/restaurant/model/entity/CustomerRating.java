package com.restaurant.model.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customerRatings")
public class CustomerRating {

    @Id
    @NotEmpty
    private String reservation;

    @NotNull
    private double rating;

}
