package com.springrest.services;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springrest.entity.Courses;

public interface CourseServices {
   public List<Courses> getCourse();
   public Courses getCourses(long id);
   public Courses addcourse(Courses courses);
   public Courses updatecourse(Courses course);
   public void deletecourse(long id);
}