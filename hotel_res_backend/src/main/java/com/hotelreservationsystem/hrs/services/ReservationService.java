package com.hotelreservationsystem.hrs.services;

import com.hotelreservationsystem.hrs.dtos.CreateReservationDTO;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    String createReservation(CreateReservationDTO createReservationDTO);

    List<String> findHotelIdsByDates(Date checkinDate, Date checkoutDate);
}
