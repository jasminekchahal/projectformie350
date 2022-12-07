package com.restaurant.controller;

import com.restaurant.controller.exceptions.CancelledReservationNotFoundException;
import com.restaurant.model.entity.Active_Reservations;
import com.restaurant.model.entity.Cancelled_Reservation;
import com.restaurant.model.repository.ActiveReservationRepository;
import com.restaurant.model.repository.CancelledReservationRepository;
import com.restaurant.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import com.restaurant.controller.ActiveReservationController;


@CrossOrigin
@RestController
public class CancelledReservationController{

    @Autowired
    private final CancelledReservationRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ActiveReservationRepository activeReservationRepository;

    @Autowired
    private ActiveReservationController activeReservationController;

    @Autowired
    public CancelledReservationController(CancelledReservationRepository repository){this.repository = repository;}

    @GetMapping("/CancelledReservations")
    List<Cancelled_Reservation> retrieveAllCancelledReservation() {
        return repository.findAll();
    }

    @GetMapping("/CancelledReservations/{reservation_id}")
    Cancelled_Reservation retrieveReservation(@PathVariable("reservation_id") String reservation_id) {
        return repository.findById(reservation_id)
                .orElseThrow(() -> new CancelledReservationNotFoundException(reservation_id));
    }

    @PostMapping("/CancelledReservations/{reservation_id}")
    Cancelled_Reservation createCancelledReservation(@PathVariable("reservation_id") String reservation_id){
        Cancelled_Reservation cancelled_reservation = new Cancelled_Reservation();

        Active_Reservations newReservation = activeReservationRepository.findById(reservation_id).orElseThrow(
                () -> new CancelledReservationNotFoundException(reservation_id));

        cancelled_reservation.setReservation_id(reservation_id);
        cancelled_reservation.setCustomer(newReservation.getCustomer());
        cancelled_reservation.setGuest_size(newReservation.getGuest_size());
        cancelled_reservation.setDate_time(newReservation.getDate_time());
        cancelled_reservation.setDate_cancelled(Date.valueOf(LocalDate.now()));

        activeReservationController.deleteReservation(reservation_id);

        return repository.save(cancelled_reservation);
    }
    /*@DeleteMapping("/CancelledReservations/{reservation_id}")
    void deleteCancelledReservation(@PathVariable("reservation_id") String reservation_id) {
        repository.deleteById(reservation_id);
    }*/
}
