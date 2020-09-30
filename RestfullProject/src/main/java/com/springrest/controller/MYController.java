package com.springrest.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.entity.Courses;
import com.springrest.services.*;

@RestController
public class MYController {
	
	@Autowired
	private CourseServices course;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application...";
	}

	//Get the Courses
	@RequestMapping(path = "/courses", method = RequestMethod.GET)
//	@GetMapping(path = "/course")
	public List<Courses> getCourse(){
		return this.course.getCourse();
	}
	
	//Get Single Course
	@RequestMapping(path = "/courses/{id}", method = RequestMethod.GET)
//	@GetMapping("/courses/{id}")
	public Courses getCourses(@PathVariable String id) {
		return this.course.getCourses(Long.parseLong(id));
	}
	
	//Create new Course
	@RequestMapping(path = "/courses", method = RequestMethod.POST, consumes = "application/json")
//	@PostMapping(path = "/courses", consumes = "application/json")
	public Courses addCourse(@RequestBody Courses courses) {
		return this.course.addcourse(courses);
	}
	
	//Update the Course
	@RequestMapping(path = "/courses", method = RequestMethod.PUT, consumes = "application/json")
//	@PutMapping(path = "/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.course.updatecourse(course);
	}
	
	//Delete the Course
	@RequestMapping(path = "/courses/{id}", method = RequestMethod.DELETE)
//	@PutMapping(path = "/courses")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
		try {
			this.course.deletecourse(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}