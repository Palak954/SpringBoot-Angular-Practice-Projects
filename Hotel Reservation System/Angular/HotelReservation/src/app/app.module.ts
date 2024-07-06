import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { BookReservationComponent } from './book-reservation/book-reservation.component';
import { ViewReservationsComponent } from './view-reservations/view-reservations.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { EditReservationComponent } from './edit-reservation/edit-reservation.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    BookReservationComponent,
    ViewReservationsComponent,
    NotFoundComponent,
    EditReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
