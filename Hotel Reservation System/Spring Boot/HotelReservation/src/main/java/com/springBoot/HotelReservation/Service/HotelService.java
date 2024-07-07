package com.springBoot.HotelReservation.Service;

import com.springBoot.HotelReservation.Entity.Reservation;
import com.springBoot.HotelReservation.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Reservation bookReservation(Reservation reservation){
        return hotelRepository.save(reservation);
    }
    public List<Reservation> fetchReservations(){
        return hotelRepository.findAll();
    }

    public Reservation fetchReservation(int id){
        return hotelRepository.findById(id);
    }
    public Reservation updateReservation(int id , Reservation reservation){
        Reservation reservation1 = hotelRepository.findById(id);
        if(reservation1 != null){
            reservation1.setName(reservation.getName());
            reservation1.setAddress(reservation.getAddress());
            reservation1.setContact(reservation.getContact());
            reservation1.setCountry(reservation.getCountry());
            reservation1.setCheckInDate(reservation.getCheckInDate());
            reservation1.setCheckOutDate(reservation.getCheckOutDate());
            reservation1.setEmail(reservation.getEmail());
            reservation1.setRoomNumber(reservation.getRoomNumber());
        }
        return hotelRepository.save(reservation1);
    }
    public ResponseEntity<?> deleteReservation(int id){
        Reservation reservation = hotelRepository.findById(id);
        Map<String, String> response = new HashMap<>();
        if (reservation != null) {
            hotelRepository.deleteById(id);
            response.put("message", "Reservation is deleted Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Reservation is not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
