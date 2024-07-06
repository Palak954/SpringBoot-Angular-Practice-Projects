import { Component, OnInit } from '@angular/core';
import { reservation } from 'src/model/reservation';
import { ReservationServiceService } from '../service/reservation-service.service';

@Component({
  selector: 'app-view-reservations',
  templateUrl: './view-reservations.component.html',
  styleUrls: ['./view-reservations.component.css']
})
export class ViewReservationsComponent implements OnInit {
  Reservation:any;
  constructor(private reservationService : ReservationServiceService) { }

  ngOnInit(): void {
    this.reservationService.fetchReservations().subscribe((data)=>{
      console.log(data);
      this.Reservation = data;
    })
  }

}
