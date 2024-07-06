package com.springBoot.HotelReservation.Controller;

import com.springBoot.HotelReservation.Entity.Reservation;
import com.springBoot.HotelReservation.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @RequestMapping("/book_reservation")
    public Reservation bookReservation(@RequestBody Reservation reservation){
        return hotelService.bookReservation(reservation);
    }
    @RequestMapping("/fetch_reservations")
    public List<Reservation> fetchReservations(){
        return hotelService.fetchReservations();
    }

    @RequestMapping("/fetch_reservation/{id}")
    public Reservation fetchReservation(@PathVariable int id){
        return hotelService.fetchReservation(id);
    }
}
