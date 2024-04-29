package com.hotelreservationsystem.hrs.models;

import com.hotelreservationsystem.hrs.pojo.Guest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reservations")
public class Reservation {

    @Id
    private String resId; // MongoDB uses String for IDs

    private String resHotelId;
    private String resHotelName;
    private Double resHotelPricePerNight;
    private List<Guest> resGuestList;
    private Date resCheckinDate;
    private Date resCheckoutDate;
    private Integer resGuestCount;
}