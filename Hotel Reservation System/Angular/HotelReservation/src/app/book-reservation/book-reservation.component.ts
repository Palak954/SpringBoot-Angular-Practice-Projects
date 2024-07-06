import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { reservation } from 'src/model/reservation';
import { ReservationServiceService } from '../service/reservation-service.service';

@Component({
  selector: 'app-book-reservation',
  templateUrl: './book-reservation.component.html',
  styleUrls: ['./book-reservation.component.css']
})
export class BookReservationComponent implements OnInit {
  Reservation : reservation = new reservation();
  constructor(private reservationService : ReservationServiceService) { }

  ngOnInit(): void {
  }
  onSubmit(reservation:any){
    console.log(reservation.value);
    this.reservationService.bookReservation(reservation.value).subscribe((data)=>{
      console.log(data);
    })
    reservation.reset();
  }
}
