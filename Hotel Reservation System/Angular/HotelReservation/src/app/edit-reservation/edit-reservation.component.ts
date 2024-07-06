import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReservationServiceService } from '../service/reservation-service.service';
import { reservation } from 'src/model/reservation';

@Component({
  selector: 'app-edit-reservation',
  templateUrl: './edit-reservation.component.html',
  styleUrls: ['./edit-reservation.component.css']
})
export class EditReservationComponent implements OnInit {
  reservationId : number;
  fetchreservation : any = new reservation();
  constructor(private route : ActivatedRoute , private reservationService : ReservationServiceService) { }

  ngOnInit(): void {
    this.reservationId = this.route.snapshot.params["id"];
    this.reservationService.fetchReservation(this.reservationId).subscribe((data : any)=>{
      this.fetchreservation = data;
    })
  }
  onUpdate(reservation:any){
    console.log(reservation.value);
  }

}
