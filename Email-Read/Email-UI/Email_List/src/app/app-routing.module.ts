import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmailListComponent } from './email-list/email-list.component';

const routes: Routes = [
  {
    path:'',
    component:EmailListComponent
  },
  {
    path:'email',
    component:EmailListComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
