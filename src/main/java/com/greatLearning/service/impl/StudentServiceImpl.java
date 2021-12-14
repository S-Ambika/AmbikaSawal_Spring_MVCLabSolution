package com.greatLearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.dao.StudentRepository;
import com.greatLearning.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentDetailsRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDetailsRepository.findAll();
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentDetailsRepository.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentDetailsRepository.deleteById(theId);

	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub

		return studentDetailsRepository.findById(theId);
	}

}
