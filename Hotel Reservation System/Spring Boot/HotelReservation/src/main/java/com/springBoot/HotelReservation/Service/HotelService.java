package com.springBoot.HotelReservation.Service;

import com.springBoot.HotelReservation.Entity.Reservation;
import com.springBoot.HotelReservation.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Reservation bookReservation(Reservation reservation){
        return hotelRepository.save(reservation);
    }

}
