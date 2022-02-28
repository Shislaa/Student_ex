package cybersoft.javabackend.java16.restfulapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16.restfulapi.model.Student;

@RestController
public class StudentController {
	List<Student> students = new ArrayList<>();
	
	@GetMapping("/savestudentparam")
	public Object saveStudentParam(@RequestParam(name = "name",required = false) String name,@RequestParam(name = "age",required = false) int age) {
		Student student = new Student(name,age);
		System.out.println("This is new student name: " + name + " and age: " + age );
		students.add(student);
		return students;
	}
	
	@GetMapping("/savestudent/path/{name}/{age}")
	public Object saveStudent(@PathVariable String name, @PathVariable int age) {
		Student student = new Student(name,age);
		System.out.println("This is new student name: " + name + " and age: " + age );
		students.add(student);
		return students;
	}
	
	@GetMapping("/savestudentrequest")
	public Object saveStudentRequest(@RequestBody Student student ) {
		System.out.println("This is new student name: " + student.getName() + " and age: " + student.getAge() );
		students.add(student);
		return students;
	}
	
	
}
