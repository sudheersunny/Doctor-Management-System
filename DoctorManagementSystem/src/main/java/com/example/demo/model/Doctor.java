package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "doctor_table")
@DynamicUpdate
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	private String lastName;
	private String email;
	private int mobileno;
	private String city;
	private String hospitalname;
	
	public Doctor() {}
	
	public Doctor(String firstName, String lastName, String email, int mobileno, String city, String hospitalname) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email = email;
		this.mobileno=mobileno;
		this.city=city;
		this.hospitalname=hospitalname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int i) {
		this.mobileno = i;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	
	

}
