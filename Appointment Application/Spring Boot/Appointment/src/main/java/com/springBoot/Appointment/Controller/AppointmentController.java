package com.springBoot.Appointment.Controller;

import com.springBoot.Appointment.Entity.Appointment;
import com.springBoot.Appointment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins= "http://localhost:4200")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @PostMapping("/insertAppointment")
    public Appointment insertAppointment(@RequestBody Appointment appointment){
        return appointmentService.postAppointment(appointment);
    }
    @GetMapping("/fetchAppointments")
    public List<Appointment> fetchAppointments(){
        return appointmentService.getAppointments();
    }
    @DeleteMapping("/deleteAppointment/{id}")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }
    @GetMapping("/fetchAppointment/{id}")
    public Appointment fetchAppointment(@PathVariable int id){
        return appointmentService.getAppointment(id);
    }
    @PutMapping("/updateAppointment/{id}")
    public Appointment updateAppointment(@PathVariable int id , @RequestBody Appointment appointment){
        return appointmentService.updateAppointment(id , appointment);
    }
}
