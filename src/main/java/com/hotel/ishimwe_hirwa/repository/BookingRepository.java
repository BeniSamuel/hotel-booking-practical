package com.hotel.ishimwe_hirwa.repository;

import com.hotel.ishimwe_hirwa.model.Booking;
import com.hotel.ishimwe_hirwa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> getBookingsByUser (User user);
    Booking getBookingsById(Long id);
}
