package com.restaurant.model.repository;

import com.restaurant.model.entity.Active_Reservations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveReservationRepository extends JpaRepository<Active_Reservations, String> {

}
