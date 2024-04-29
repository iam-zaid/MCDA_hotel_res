package com.hotelreservationsystem.hrs.services;

import com.hotelreservationsystem.hrs.dtos.CreateHotelsDTO;
import com.hotelreservationsystem.hrs.filters.HotelFilter;
import com.hotelreservationsystem.hrs.models.Hotel;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {
    void createHotels(CreateHotelsDTO createHotelsDTO);

    List<Hotel> filterHotels(HotelFilter hotelFilter);

    Hotel getHotelById(ObjectId hotelId);
}
