import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Appointments } from 'src/appointments';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-update-appointment',
  templateUrl: './update-appointment.component.html',
  styleUrls: ['./update-appointment.component.css']
})
export class UpdateAppointmentComponent implements OnInit {
  
  onUpdate(){
    console.log("record is updated successfully");
    this.appointmentService.updateAppointment(this.appointmentId , this.appointment).subscribe((data)=>{
      this.appointment = data;
    })
    this.route.navigate(["/appointments"]);
  }
  constructor(private activatedRoute : ActivatedRoute , private appointmentService : AppointmentService , private route : Router) { }
  appointmentId : number;
  appointment : any = new Appointments();
  ngOnInit(): void {
    this.appointmentId = this.activatedRoute.snapshot.params["id"];
    this.appointmentService.fetchAppointmentWithId(this.appointmentId).subscribe((data : any) => {
      this.appointment = data;
      console.log(this.appointment);
    });
  }
}
