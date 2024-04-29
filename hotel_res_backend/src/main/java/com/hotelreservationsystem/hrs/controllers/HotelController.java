package com.hotelreservationsystem.hrs.controllers;


import com.hotelreservationsystem.hrs.dtos.CreateHotelsDTO;
import com.hotelreservationsystem.hrs.filters.HotelFilter;
import com.hotelreservationsystem.hrs.models.Hotel;
import com.hotelreservationsystem.hrs.services.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<String> createHotels(HttpServletRequest http, @RequestBody CreateHotelsDTO createHotelsDTO) {
        hotelService.createHotels(createHotelsDTO);
        return new ResponseEntity<>("Hotel created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Hotel>> hotelFilter(HttpServletRequest http, @RequestBody HotelFilter hotelFilter) {
        List<Hotel> filteredHotels = hotelService.filterHotels(hotelFilter);
        return new ResponseEntity<>(filteredHotels, HttpStatus.OK);
    }

    @PostMapping("/get-by-id")
    public ResponseEntity<Hotel> getHotelById(@RequestBody String hotelId) {
        try {
            ObjectId objectId = new ObjectId(hotelId); // Convert String to ObjectId
            Hotel hotel = hotelService.getHotelById(objectId);
            if (hotel != null) {
                return new ResponseEntity<>(hotel, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            // Handle invalid ObjectId format
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
