import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../services/appointment.service';
import { Appointments } from 'src/appointments';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {
  appointments : Appointments[];
  constructor(private appointmentService : AppointmentService) { }

  ngOnInit(): void {
    this.fetchAppointments();
  }
  fetchAppointments(){
    this.appointmentService.fetchAppointment().subscribe((data)=>{
      this.appointments = data;
    })
  }
  onDelete(id : number){
    this.appointmentService.deleteAppointment(id).subscribe((data)=>{
      console.log("record is successfully deleted");
      this.fetchAppointments();
    });
  }
}
