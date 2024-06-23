import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AppointmentService } from '../services/appointment.service';
import { AppointmentsComponent } from '../appointments/appointments.component';

@Component({
  selector: 'app-book-appointment',
  templateUrl: './book-appointment.component.html',
  styleUrls: ['./book-appointment.component.css']
})
export class BookAppointmentComponent implements OnInit {
  
  constructor(private route : Router , private appointmentService : AppointmentService) { }

  ngOnInit(): void {
  }
  onSubmit(appointments : any){
    this.appointmentService.bookAppointment(appointments.value).subscribe((data)=>{
      console.log(data);
    })
    this.route.navigate(["/appointments"]);
    this.appointmentService.fetchAppointment();
  }
}
