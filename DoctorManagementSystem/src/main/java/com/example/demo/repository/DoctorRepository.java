package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findByhospitalname(String hospitalname);
	

}
