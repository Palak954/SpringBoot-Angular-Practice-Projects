package com.springBoot.HotelReservation.Controller;

import com.springBoot.HotelReservation.Entity.Reservation;
import com.springBoot.HotelReservation.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @RequestMapping("/book_reservation")
    public Reservation bookReservation(@RequestBody Reservation reservation){
        return hotelService.bookReservation(reservation);
    }

}
