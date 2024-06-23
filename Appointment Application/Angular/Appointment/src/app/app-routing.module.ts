import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentsComponent } from './appointments/appointments.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { UpdateAppointmentComponent } from './update-appointment/update-appointment.component';

const routes: Routes = [
    {
    path: "appointments" , 
    component: AppointmentsComponent
    } , 
    {
      path: "" , 
      redirectTo: "appointments" ,
      pathMatch: "full"
    } , 
  {
    path: "appointment/book_appointment" , 
    component:BookAppointmentComponent
  } , 
  {
    path: "appointment/edit_appointment/:id",
    component:UpdateAppointmentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
