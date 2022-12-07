package com.restaurant.controller;

import com.restaurant.controller.Dto.ReservationDto;
import com.restaurant.controller.exceptions.CustomerNotFoundException;
import com.restaurant.controller.exceptions.ReservationNotFoundException;
import com.restaurant.model.entity.Active_Reservations;
import com.restaurant.model.entity.Customer;
import com.restaurant.model.entity.Reservation;
import com.restaurant.model.repository.ActiveReservationRepository;
import com.restaurant.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@CrossOrigin
@RestController
public class ActiveReservationController {

    @Autowired
    private final ActiveReservationRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public ActiveReservationController(ActiveReservationRepository repository){this.repository = repository;}

    @GetMapping("/Reservations")
    List<Active_Reservations> retrieveAllReservation() {
        return repository.findAll();
    }

    @GetMapping("/Reservations/{reservation_id}")
    Active_Reservations retrieveReservation(@PathVariable("reservation_id") String reservation_id) {
        return repository.findById(reservation_id)
                .orElseThrow(() -> new ReservationNotFoundException(reservation_id));
    }

    @PostMapping("/Reservations")
    Active_Reservations createReservation(@RequestBody ReservationDto reservationDto){
        Active_Reservations newReservation = new Active_Reservations();
        Customer customer = customerRepository.findById(reservationDto.getPhone_number()).orElseThrow(
                () -> new CustomerNotFoundException(reservationDto.getPhone_number()));

        String name = customer.getName();
        String number = customer.getNumber();
        String resId = "RES"+ name.substring(name.length()-2) + number.substring(number.length()-4);

        newReservation.setReservation_id(resId);
        newReservation.setCustomer(customer);
        newReservation.setGuest_size(reservationDto.getGuest_size());
        newReservation.setDate_time(reservationDto.getDate_time());

        return repository.save(newReservation);

    }

    @PutMapping("/Reservations/{reservation_id}")
    Reservation updateReservation(@RequestBody ReservationDto reservationDto, @PathVariable("reservation_id") String reservation_id) {
        return repository.findById(reservation_id)
                .map(reservation -> {

                    reservation.setDate_time(reservationDto.getDate_time());

                    reservation.setGuest_size(reservationDto.getGuest_size());

                    Customer customer = customerRepository.findById(reservationDto.getPhone_number()).orElseThrow(
                            () -> new CustomerNotFoundException(reservationDto.getPhone_number()));
                    reservation.setCustomer(customer);

                    return repository.save(reservation);
                })
                .orElseGet(() -> {
                    return this.createReservation(reservationDto);
                });
    }

    @DeleteMapping("/Reservations/{reservation_id}")
    void deleteReservation(@PathVariable("reservation_id") String reservation_id) {
        repository.deleteById(reservation_id);
    }

}



