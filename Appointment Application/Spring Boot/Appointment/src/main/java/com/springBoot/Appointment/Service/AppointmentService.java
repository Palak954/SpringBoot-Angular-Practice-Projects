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

    public void deleteAppointment(int id){
        appointmentRepository.deleteById(id);
    }
    public Appointment getAppointment(int id){
        return appointmentRepository.findById(id);
    }
    public Appointment updateAppointment(int id , Appointment appointment){
        Appointment fetchAppointment = appointmentRepository.findById(id);
        fetchAppointment.setPatientName(appointment.getPatientName());
        fetchAppointment.setDescription(appointment.getDescription());
        fetchAppointment.setDate(appointment.getDate());
        return appointmentRepository.save(fetchAppointment);
    }
}
