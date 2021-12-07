package com.greatLearning.service;

import java.util.List;

import com.greatLearning.model.Student;

public interface StudentDetailsService {

	public List<Student> findAll();

	public void save(Student theStudent);

	public void deleteById(int theId);
	
	public Student findById(int theId);


}
