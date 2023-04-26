package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorServiceImpl;


@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class DoctorController {
	
	
	@Autowired
	public DoctorServiceImpl doctorService;
	private DoctorRepository doctorrepository;
	public   DoctorController
	(DoctorServiceImpl doctorService, DoctorRepository doctorrepository){
		this.doctorService=doctorService;
		this.doctorrepository=doctorrepository;
	}

	
	
	
	
		
		@PostMapping("doctors")
		public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doc){
			return new ResponseEntity<Doctor>(doctorService.saveDoctor(doc), HttpStatus.CREATED);
		}
		
		@PutMapping("doctors/{docId}")
		public ResponseEntity<Doctor> updateDoctorDetailsById(@PathVariable("docId") int id,
				@RequestBody Doctor doc){
			return new ResponseEntity<Doctor>(doctorService.updateDoctorDetails(doc, id), HttpStatus.OK);
			
		}
	/*	@GetMapping("doctors")
		public List<Doctor> getAllDocs(){
			return doctorService.getDoctorsFromDb();
		}
		*/
		@GetMapping("doctors/{id}")
		public ResponseEntity<Doctor>  getDoctorById(@PathVariable("id")  int docId){
			return new ResponseEntity<Doctor>(doctorService.getDoctorById(docId), HttpStatus.OK);
		}
		
		@DeleteMapping("doctors/{id}")
		public ResponseEntity<String> deleteDoctorById(@PathVariable("id")  int docId){
			doctorService.deleteDoctorById(docId);
			System.out.println("Deleted");
			return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
		}
		
		@GetMapping("/doctors")
		public ResponseEntity<List<Doctor>> getAllhospitals(@RequestParam(required=false)String name){
			try {
				List<Doctor>doctorList=new ArrayList<Doctor>();
				if(name!=null) {
					doctorrepository.findByhospitalname(name).forEach(doctorList::add);
					return new ResponseEntity<>(doctorList,HttpStatus.OK);
				}
				else {
					doctorList=doctorrepository.findAll();
					return new ResponseEntity<>(doctorList,HttpStatus.OK);
				}
			}catch(Exception e) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
