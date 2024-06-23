package com.springBoot.Appointment.Repository;
import com.springBoot.Appointment.Entity.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment , Integer> {
    Appointment findById(int id);
}
