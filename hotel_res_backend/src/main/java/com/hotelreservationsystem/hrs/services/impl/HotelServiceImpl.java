package com.hotelreservationsystem.hrs.services.impl;


import com.hotelreservationsystem.hrs.dtos.CreateHotelsDTO;
import com.hotelreservationsystem.hrs.filters.HotelFilter;
import com.hotelreservationsystem.hrs.models.Hotel;
import com.hotelreservationsystem.hrs.models.Reservation;
import com.hotelreservationsystem.hrs.pojo.Hotelpojo;
import com.hotelreservationsystem.hrs.services.HotelService;
import com.hotelreservationsystem.hrs.services.MongoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    MongoService mongoService;
    @Override
    public void createHotels(CreateHotelsDTO dto) {

        for(Hotelpojo ht:dto.getHotels()){
            Hotel hotel = new Hotel();
            hotel.setHotelName(ht.getHotelName());
            hotel.setHotelLocation(ht.getHotelLocation());
            hotel.setHotelPricePerNight(ht.getHotelPricePerNight());
            mongoService.save(hotel,"hotels");
        }

    }

    @Override
    public List<Hotel> filterHotels(HotelFilter hotelFilter) {
        Query query = new Query();

        List<Reservation> reservations = mongoService.find(hotelFilter.toQuery(), Reservation.class);

        if(reservations != null){
            List<String> hotelIds = reservations.stream().map(Reservation::getResHotelId).toList();
            query.addCriteria(Criteria.where("_id").nin(hotelIds));
        }

        List<Hotel> hotels = mongoService.find(query, Hotel.class);
        hotels.forEach(hotel -> hotel.setHotelAvailability(true));
        return hotels;
    }

    @Override
    public Hotel getHotelById(ObjectId hotelId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(hotelId));
        return mongoService.findOne(query, Hotel.class);
    }
}

