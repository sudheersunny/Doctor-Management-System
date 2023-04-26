package com.example.demo.DocservInter;

import java.util.List;

import com.example.demo.model.Doctor;


public interface DoctorServ {
	
	Doctor saveDoctor(Doctor doc);
	List<Doctor>  getDoctorsFromDb();
	Doctor getDoctorById(int docId);
	void deleteDoctorById(int docId);
	Doctor updateDoctorDetails(Doctor newVal, int docId);
	
}