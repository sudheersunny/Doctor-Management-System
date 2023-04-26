package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DocservInter.DoctorServ;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorServ{

	DoctorRepository docRepo;

	public DoctorServiceImpl(DoctorRepository docRepo) {
		this.docRepo = docRepo;
	}
	
	public Doctor saveDoctor(Doctor doc) {
		return docRepo.save(doc);
	}
	
	@Override
	public List<Doctor> getDoctorsFromDb() {
		return docRepo.findAll();
	}
	
	@Override//5
	public Doctor getDoctorById(int docId) {
		Optional<Doctor> doc = docRepo.findById(docId);
		if(doc.isPresent()) {
			return doc.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	public Doctor updateDoctorDetails(Doctor newVal, int docId) {
		Optional<Doctor> doc = docRepo.findById(docId);
		if(doc.isPresent()) {
			Doctor existingDoc = doc.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingDoc.setFirstName(newVal.getFirstName());
			existingDoc.setLastName(newVal.getLastName());
			existingDoc.setEmail(newVal.getEmail());
			existingDoc.setHospitalname(newVal.getHospitalname());
			existingDoc.setCity(newVal.getCity());
			existingDoc.setMobileno(newVal.getMobileno());
			docRepo.save(existingDoc);
			return existingDoc;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void deleteDoctorById(int docId) {
		Optional<Doctor> doc = docRepo.findById(docId);
		if(doc.isPresent()) {
			docRepo.deleteById(docId);
		}
	}
}