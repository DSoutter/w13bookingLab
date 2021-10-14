package com.codeclan.example.bookingLab.components;

import com.codeclan.example.bookingLab.models.Booking;
import com.codeclan.example.bookingLab.models.Course;
import com.codeclan.example.bookingLab.models.Customer;
import com.codeclan.example.bookingLab.repositories.BookingRepository;
import com.codeclan.example.bookingLab.repositories.CourseRepository;
import com.codeclan.example.bookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Course course1 = new Course("Python", "Edinburgh", 4.3);
        courseRepository.save(course1);

        Course course2 = new Course("JavaScript", "Glasgow", 3.3);
        courseRepository.save(course2);

        Course course3 = new Course("Java", "Inverness", 3.8);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Duncan", "Innerleithen", 28);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jeremy", "Edinburgh", 33);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("14/10/2021", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("10/10/2021", course2, customer1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("14/01/2021", course3, customer1);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("15/10/2021", course1, customer2);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("12/10/2021", course2, customer2);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("24/10/2021", course3, customer2);
        bookingRepository.save(booking6);

    }
}
