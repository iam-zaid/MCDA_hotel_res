package com.hotelreservationsystem.hrs.dtos;

import com.hotelreservationsystem.hrs.pojo.Guest;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateReservationDTO {

    private String resHotelId;
    private List<Guest> resGuestList;
    private Date resCheckinDate;
    private Date resCheckoutDate;
    private Integer resGuestCount;
}
