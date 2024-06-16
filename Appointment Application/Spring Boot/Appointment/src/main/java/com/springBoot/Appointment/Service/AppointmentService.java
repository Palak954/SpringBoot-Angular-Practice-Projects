package com.springBoot.Appointment.Service;

import com.springBoot.Appointment.Entity.Appointment;
import com.springBoot.Appointment.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    public Appointment postAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }
}
