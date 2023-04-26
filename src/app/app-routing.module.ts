import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { UpdateDoctorComponent } from './update-doctor/update-doctor.component';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuardService } from './auth-guard.service';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: 'doctors', component: DoctorListComponent,canActivate:[AuthGuardService]},
  {path: 'create-doctor', component: CreateDoctorComponent,canActivate:[AuthGuardService]},
  {path: '', redirectTo: 'doctors', pathMatch: 'full'},
  {path: 'update-doctor/:id', component: UpdateDoctorComponent,canActivate:[AuthGuardService]},
  {path: 'doctor-details/:id', component: DoctorDetailsComponent,canActivate:[AuthGuardService]},
  {path:  'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent,canActivate:[AuthGuardService]  },
  {path: 'signup', component: SignupComponent,}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
