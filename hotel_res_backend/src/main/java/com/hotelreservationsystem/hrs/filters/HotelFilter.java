package com.hotelreservationsystem.hrs.filters;


import com.hotelreservationsystem.hrs.models.Reservation;
import com.hotelreservationsystem.hrs.services.ReservationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class HotelFilter  {

    private String checkinDate;
    private String checkoutDate;


    public Query toQuery(){

        Query query = new Query();

        Criteria dateCriteria = Criteria.where("resCheckinDate").lte(checkoutDate)
                .and("resCheckoutDate").gte(checkinDate);

        query.addCriteria(dateCriteria);

        return query;

    }
}
