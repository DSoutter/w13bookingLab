package com.codeclan.example.bookingLab.controllers;

import com.codeclan.example.bookingLab.models.Customer;
import com.codeclan.example.bookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name="courseName", required = false) String courseName,
            @RequestParam(name="town", required = false) String town,
            @RequestParam(name="age", required = false) Integer age
            ){
        if (age != null && courseName != null && town != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
        }
        if (courseName != null && town != null){
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
    }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer (@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
