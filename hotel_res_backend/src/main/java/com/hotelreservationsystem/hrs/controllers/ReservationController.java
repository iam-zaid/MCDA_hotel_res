package com.hotelreservationsystem.hrs.controllers;

import com.hotelreservationsystem.hrs.dtos.CreateReservationDTO;
import com.hotelreservationsystem.hrs.services.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<String> createReservation(HttpServletRequest http, @RequestBody CreateReservationDTO createReservationDTO) {
        String resId = reservationService.createReservation(createReservationDTO);
        return new ResponseEntity<>("Reservation created successfully! Reservation ID: " + resId, HttpStatus.CREATED);
    }
}


