package com.codeclan.example.bookingLab.repositories;

import com.codeclan.example.bookingLab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
