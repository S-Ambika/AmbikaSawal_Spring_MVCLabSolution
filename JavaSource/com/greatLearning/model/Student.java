package com.greatLearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int student_id;


	@Column(name="name")
	private String name;


	@Column(name="department")
	private String department;


	@Column(name="country")
	private String country;


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Student(String name, String department, String country) {
		this.name = name;
		this.department = department;
		this.country = country;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}
	






}
