package com.restaurant.model.repository;


import com.restaurant.model.entity.Completed_Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedReservationRepository extends JpaRepository<Completed_Reservation, String> {
}
