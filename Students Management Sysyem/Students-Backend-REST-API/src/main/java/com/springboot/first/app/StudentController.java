package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Kris", "Danovska");
	}

	@GetMapping("/students")
	public List<Student> getStudents(){		
		List<Student> students = new ArrayList<>();
		students.add(new Student("St1", "Last name1"));
		students.add(new Student("St2", "Last name2"));
		students.add(new Student("St3", "Last name3"));
		students.add(new Student("St4", "Last name4"));

		return students;
	}
	
	// http://localhost:8080/student/1
	// @PathVariable annotation
	@GetMapping("/student/{firstName}/{lastName}/")
	public Student studentPathVariable(@PathVariable("firstName") String firstName, 
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	// build rest API to handle query parameters
	// http://localhost:8080/student/query?firstName=Kris&lastName=Danovska
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	
	
}
