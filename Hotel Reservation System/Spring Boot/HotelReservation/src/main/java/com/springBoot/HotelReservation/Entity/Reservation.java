package com.springBoot.HotelReservation.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Reservation")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Guest_Id")
    private int id;
    @Column(name="Guest_Name")
    private String name;
    @Column(name="CheckIn_Date")
    private LocalDate checkInDate;
    @Column(name="CheckOut_Date")
    private LocalDate checkOutDate;
    @Column(name="Email")
    private String email;
    @Column(name="Contact")
    private String contact;
    @Column(name="Address")
    private String address;
    @Column(name="Country")
    private String country;
    @Column(name="Room_Number")
    private int roomNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Reservation() {
    }

    public Reservation(int id, String name, LocalDate checkInDate, LocalDate checkOutDate, String email, String contact, String address, String country, int roomNumber) {
        this.id = id;
        this.name = name;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.country = country;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
