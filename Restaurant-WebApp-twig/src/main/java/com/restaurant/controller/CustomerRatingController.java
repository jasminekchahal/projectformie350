package com.restaurant.controller;

import com.restaurant.controller.exceptions.CancelledReservationNotFoundException;
import com.restaurant.controller.exceptions.CustomerRatingNotFoundException;
import com.restaurant.model.entity.Active_Reservations;
import com.restaurant.model.entity.CustomerRating;
import com.restaurant.model.repository.ActiveReservationRepository;
import com.restaurant.model.repository.CustomerRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class CustomerRatingController {

    @Autowired
    private final CustomerRatingRepository repository;

    @Autowired
    private ActiveReservationRepository activeReservationRepository;

    @Autowired
    public CustomerRatingController(CustomerRatingRepository repository) {this.repository = repository;}

    @GetMapping("/CustomerRatings")
    List<CustomerRating> retrieveAllCustomerRatings() {
        return repository.findAll();
    }

    @PostMapping("/CustomerRatings/{reservation_id}")
    CustomerRating createCustomerRatings(@RequestBody CustomerRating customerRating, @PathVariable("reservation_id") String reservation_id){
        Active_Reservations newReservation = activeReservationRepository.findById(reservation_id).orElseThrow(
                () -> new CustomerRatingNotFoundException(reservation_id));

        customerRating.setReservation(reservation_id);

        return repository.save(customerRating);
    }

}
