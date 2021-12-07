package com.greatLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.model.Student;
import com.greatLearning.service.StudentDetailsService;

@Controller
@RequestMapping("/students")

public class StudentDetailsController {

	@Autowired
	StudentDetailsService studentDetailsService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		List<Student> theStudents = studentDetailsService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("student_id") int theId, Model theModel) {

		// get the Book from the service
		Student theStudent = studentDetailsService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("student_id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student theStudent;
		if (id != 0) {
			theStudent = studentDetailsService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(name, department, country);
		// save the Book
		studentDetailsService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("student_id") int theId) {

		// delete the Book
		studentDetailsService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/students/list";

	}

}
