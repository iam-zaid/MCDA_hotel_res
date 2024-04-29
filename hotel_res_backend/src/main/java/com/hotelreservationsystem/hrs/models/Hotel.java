package com.hotelreservationsystem.hrs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
public class Hotel {

    @Id
    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private Double hotelPricePerNight;
    @Transient
    private Boolean hotelAvailability; // Not stored in MongoDB
}
