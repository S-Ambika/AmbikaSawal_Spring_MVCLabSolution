package com.greatLearning.service.impl;

import java.util.List;

import com.greatLearning.model.Student;

public interface StudentService {

	public List<Student> findAll();

	public void save(Student theStudent);

	public void deleteById(int theId);
	
	public Student findById(int theId);


}
