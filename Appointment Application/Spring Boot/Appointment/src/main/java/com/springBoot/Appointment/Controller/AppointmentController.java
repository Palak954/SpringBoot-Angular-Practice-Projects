package com.springBoot.Appointment.Controller;

import com.springBoot.Appointment.Entity.Appointment;
import com.springBoot.Appointment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("/insertAppointment")
    public Appointment insertAppointment(@RequestBody Appointment appointment){
        return appointmentService.postAppointment(appointment);
    }
    @GetMapping("/fetchAppointment")
    public List<Appointment> fetchAppointments(){
        return appointmentService.getAppointments();
    }
}
