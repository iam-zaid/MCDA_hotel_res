package com.hotelreservationsystem.hrs.services.impl;

import com.hotelreservationsystem.hrs.dtos.CreateReservationDTO;
import com.hotelreservationsystem.hrs.models.Reservation;
import com.hotelreservationsystem.hrs.services.MongoService;
import com.hotelreservationsystem.hrs.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    MongoService mongoService;
    @Override
    public String createReservation(CreateReservationDTO resdto) {

        Reservation res = new Reservation();
        res.setResHotelId(resdto.getResHotelId());
        res.setResCheckinDate(resdto.getResCheckinDate());
        res.setResCheckoutDate(resdto.getResCheckoutDate());
        res.setResGuestList(resdto.getResGuestList());
        res.setResGuestCount(resdto.getResGuestCount());

        res = mongoService.save(res,"reservations");

        return res.getResId();
    }

    @Override
    public List<String> findHotelIdsByDates(Date checkinDate, Date checkoutDate) {
        Criteria dateCriteria = Criteria.where("resCheckinDate").lte(checkoutDate)
                .and("resCheckoutDate").gte(checkinDate);

        Query query = new Query(dateCriteria);

        List<Reservation> reservations = mongoService.find(query, Reservation.class);

        return reservations.stream().map(Reservation::getResHotelId).collect(Collectors.toList());
    }
}

