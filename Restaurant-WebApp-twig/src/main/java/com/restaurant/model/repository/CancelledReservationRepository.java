package com.restaurant.model.repository;


import com.restaurant.model.entity.Cancelled_Reservation;
import com.restaurant.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelledReservationRepository extends JpaRepository<Cancelled_Reservation, String>
{

}
