import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appointments } from 'src/appointments';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http : HttpClient) { }

  bookAppointment(appointment : Appointments){
    return this.http.post<Appointments>("http://localhost:8080/api/insertAppointment" , appointment);
  }
  fetchAppointment(){
    return this.http.get<Appointments[]>("http://localhost:8080/api/fetchAppointments");
  }
  deleteAppointment(id : number){
    return this.http.delete(`http://localhost:8080/api/deleteAppointment/${id}`);
  }
  fetchAppointmentWithId(id : number){
    return this.http.get<Appointments>(`http://localhost:8080/api/fetchAppointment/${id}`);
  }
  updateAppointment(id : number , appointment : Appointments){
    return this.http.put(`http://localhost:8080/api/updateAppointment/${id}` , appointment);
  }


}
