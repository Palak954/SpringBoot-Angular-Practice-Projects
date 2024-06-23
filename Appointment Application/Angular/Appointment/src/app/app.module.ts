import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookAppointmentComponent } from './book-appointment/book-appointment.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateAppointmentComponent } from './update-appointment/update-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    BookAppointmentComponent,
    AppointmentsComponent,
    UpdateAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
