package com.restaurant.model.repository;

import com.restaurant.model.entity.Active_Reservations;
import com.restaurant.model.entity.CustomerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRatingRepository extends JpaRepository<CustomerRating, String> {
}
