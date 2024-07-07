import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { reservation } from 'src/model/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationServiceService {

  constructor(private http:HttpClient) { }

  bookReservation(reservation : reservation){
    return this.http.post<reservation>("http://localhost:8080/hotel/book_reservation",reservation);
  }
  fetchReservations(){
    return this.http.get<reservation[]>("http://localhost:8080/hotel/fetch_reservations");
  }
  fetchReservation(id : number){
    return this.http.get<reservation>(`http://localhost:8080/hotel/fetch_reservation/${id}`);
  }
  updateReservation(id:number , reservation : reservation){
    return this.http.put(`http://localhost:8080/hotel/update_reservation/${id}`, reservation);
  }
  deleteReservation(id:number){
    return this.http.delete(`http://localhost:8080/hotel/delete_reservation/${id}`);
  }
}
