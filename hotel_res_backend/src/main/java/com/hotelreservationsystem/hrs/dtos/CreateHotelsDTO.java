package com.hotelreservationsystem.hrs.dtos;

import com.hotelreservationsystem.hrs.pojo.Hotelpojo;
import lombok.Data;

import java.util.List;

@Data
public class CreateHotelsDTO {
    List<Hotelpojo> hotels;
}
