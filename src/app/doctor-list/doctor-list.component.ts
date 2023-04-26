import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor'
import { DoctorService } from '../doctor.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit{

  doctors: Doctor[] = [];
  hospitalname : string = '';


  constructor(private doctorService: DoctorService,
    private router: Router) { }

  ngOnInit(): void {
    this.getDoctors();
  }

  private getDoctors(){
    this.doctorService.getDoctorsList().subscribe(data => {
      this.doctors = data;
    });
  }

  doctorDetails(id: number){
    this.router.navigate(['doctor-details', id]);
  }
  updateDoctor(id: number){
    this.router.navigate(['update-doctor', id]);
  }

  deleteDoctor(id: number){
    console.log(id);
    this.doctorService.deleteDoctor(id).subscribe( data => {
      console.log(data);
      this.getDoctors();
    })
  }
confirmDelete(id : number){
  var status= confirm("You want to delete this record?");
   if (status==true) {
     this.deleteDoctor(id);
        }
        else{
          this.getDoctors();
        }
}
confirmDeleteall(){
  var status= confirm("You want to  delete all records?");
   if (status==true) {
     this.removeAllDoctors();
        }
   else{
    this.getDoctors();
        }

}
removeAllDoctors(): void {
  this.doctorService.deleteAll().subscribe(
      data => {
        console.log(data);
       // this.refreshList();
      },
      error => {
        console.log(error);
      });
}
searchByName(){
  this.doctorService.findByName(this.hospitalname)
  .subscribe(
    data => { 
    this.doctors = data;
      console.log(data);
    },
    error => {
      console.log(error);
    });
}
}
