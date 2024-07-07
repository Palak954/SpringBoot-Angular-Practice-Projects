package com.springBoot.HotelReservation.Controller;

import com.springBoot.HotelReservation.Entity.Reservation;
import com.springBoot.HotelReservation.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:57449")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/book_reservation")
    public Reservation bookReservation(@RequestBody Reservation reservation){
        return hotelService.bookReservation(reservation);
    }
    @GetMapping("/fetch_reservations")
    public List<Reservation> fetchReservations(){
        return hotelService.fetchReservations();
    }

    @GetMapping("/fetch_reservation/{id}")
    public Reservation fetchReservation(@PathVariable int id){
        return hotelService.fetchReservation(id);
    }
    @PutMapping("/update_reservation/{id}")
    public Reservation updateReservation(@PathVariable int id , @RequestBody Reservation reservation){
        return hotelService.updateReservation(id , reservation);
    }
    @DeleteMapping("/delete_reservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable int id){
        return hotelService.deleteReservation(id);
    }
}
