package com.codeclan.example.bookingLab.repositories;

import com.codeclan.example.bookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);

    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(Integer age, String town, String courseName);
//    Get all customers in a given town for a given course
//    Get all customers over a certain age in a given town for a given course

}
