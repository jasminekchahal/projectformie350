package com.restaurant.controller;

import com.restaurant.controller.Dto.CompletedReservationDto;
import com.restaurant.controller.exceptions.*;
import com.restaurant.model.entity.*;
import com.restaurant.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class CompletedReservationController {

    @Autowired
    private final CompletedReservationRepository repository;

    @Autowired
    private ActiveReservationRepository activeReservationRepository;

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private TablesRepository tablesRepository;

    @Autowired
    private ActiveReservationController activeReservationController;

    @Autowired
    private CustomerRatingController customerRatingController;

    @Autowired
    public CompletedReservationController(CompletedReservationRepository repository){this.repository = repository;}

    @GetMapping("/CompletedReservations")
    List<Completed_Reservation> retrieveAllCompletedReservation() {
        return repository.findAll();
    }

    @GetMapping("/CompletedReservations/{reservation_id}")
    Completed_Reservation retrieveReservation(@PathVariable("reservation_id") String reservation_id) {
        return repository.findById(reservation_id)
                .orElseThrow(() -> new CompletedReservationNotFoundException(reservation_id));
    }

    @PostMapping("/CompletedReservations/{reservation_id}")
    Completed_Reservation createCompletedReservations(@RequestBody CompletedReservationDto completedReservationDto, @PathVariable("reservation_id") String reservation_id){
        Completed_Reservation completed_reservation = new Completed_Reservation();

        Active_Reservations newReservation = activeReservationRepository.findById(reservation_id).orElseThrow(
                () -> new CompletedReservationNotFoundException(reservation_id));

        completed_reservation.setReservation_id(reservation_id);
        completed_reservation.setCustomer(newReservation.getCustomer());
        completed_reservation.setGuest_size(newReservation.getGuest_size());
        completed_reservation.setDate_time(newReservation.getDate_time());

        Server server = serverRepository.findById(completedReservationDto.getServer_id()).orElseThrow(
                () -> new ServerNotFoundException(completedReservationDto.getServer_id()));
        completed_reservation.setServer(server);

        Tables tables = tablesRepository.findById(completedReservationDto.getTable_id()).orElseThrow(
                () -> new TableNotFoundException(completedReservationDto.getTable_id()));
        completed_reservation.setTables(tables);

        completed_reservation.setCompleted_time(Date.valueOf(LocalDate.now()));

        CustomerRating customerRating = new CustomerRating();
        customerRating.setReservation(reservation_id);
        customerRating.setRating(completedReservationDto.getRating());

        customerRatingController.createCustomerRatings(customerRating,reservation_id);

        completed_reservation.setCustomerRating(customerRating);

        activeReservationController.deleteReservation(reservation_id);


        return repository.save(completed_reservation);
    }

/*
    @DeleteMapping("/CompletedReservations/{reservation_id}")
    void deleteCompletedReservation(@PathVariable("reservation_id") String reservation_id) {
        repository.deleteById(reservation_id);
    }
*/
}



