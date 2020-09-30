/**
 * 
 */
package com.springrest.services;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springrest.entity.Courses;

@Service
public class CourseServiceImpl implements CourseServices {
	
	List<Courses> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses(1, "JAVA", "java programming languagae"));
		list.add(new Courses(2, "PYTHON", "python programming languagae"));
		list.add(new Courses(3, "GROOVY", "goovy programming languagae"));
		list.add(new Courses(4, "C", "c programming languagae"));
		list.add(new Courses(5, "C++", "c++ programming languagae"));
	}
	

	@Override
	public List<Courses> getCourse() {
		return list;
	}

	@Override
	public Courses getCourses(long id) {
		Courses c = null;
		for(Courses course : list) {
			if(course.getId()==id) {
				c = course;
				break;
			}
		}
		return c;
	}


	@Override
	public Courses addcourse(Courses courses) {
		list.add(courses);
		return courses;
	}


	@Override
	public Courses updatecourse(Courses course) {
		for(Courses c : list) {
			if(c.getId()==course.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
		}
		return course;
	}


	@Override
	public void deletecourse(long id) {
		list = this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
	}
}