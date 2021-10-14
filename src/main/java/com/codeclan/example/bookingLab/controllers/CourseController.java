package com.codeclan.example.bookingLab.controllers;

import com.codeclan.example.bookingLab.models.Course;
import com.codeclan.example.bookingLab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "rating", required = false) Double rating,
            @RequestParam(name = "name", required = false) String name
    ) {
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
