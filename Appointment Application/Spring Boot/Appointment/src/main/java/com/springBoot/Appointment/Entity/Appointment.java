package com.springBoot.Appointment.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Book_Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointment_id")
    private int id;
    @Column(name="patient_name")
    private String patientName;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    private LocalDate date;

    public Appointment(int id, String patientName, String description, LocalDate date) {
        this.id = id;
        this.patientName = patientName;
        this.description = description;
        this.date = date;
    }

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
