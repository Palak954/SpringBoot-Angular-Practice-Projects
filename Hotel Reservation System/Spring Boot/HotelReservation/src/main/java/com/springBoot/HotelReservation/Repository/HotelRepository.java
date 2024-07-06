package com.springBoot.HotelReservation.Repository;

import com.springBoot.HotelReservation.Entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Reservation, Integer> {
    Reservation findById(int id);
}
