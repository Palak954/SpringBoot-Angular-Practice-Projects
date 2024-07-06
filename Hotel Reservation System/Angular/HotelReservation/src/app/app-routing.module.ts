import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { BookReservationComponent } from './book-reservation/book-reservation.component';
import { ViewReservationsComponent } from './view-reservations/view-reservations.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { EditReservationComponent } from './edit-reservation/edit-reservation.component';

const routes: Routes = [
  {
    path: "" , 
    component: WelcomeComponent,
    children: [
      { path: 'new', component: BookReservationComponent },
      { path: 'list', component: ViewReservationsComponent },
      { path: 'edit/:id', component:EditReservationComponent}
    ]
  },
  {
    path: "**" , 
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
