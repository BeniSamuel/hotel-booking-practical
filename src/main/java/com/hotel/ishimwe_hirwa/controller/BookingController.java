package com.hotel.ishimwe_hirwa.controller;

import com.hotel.ishimwe_hirwa.dto.BookingDto;
import com.hotel.ishimwe_hirwa.model.Booking;
import com.hotel.ishimwe_hirwa.service.BookingService;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController (BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ApiResponse<List<Booking>>> getBookingByCustomer (@RequestParam Long id) {
        List<Booking> bookings = this.bookingService.getBookingByUser(id);
        if (!bookings.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>( true, "successfully obtained bookings", bookings));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "failed to get booking by user!!", null));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Booking>> createBooking (@RequestBody BookingDto bookingDto) {
        Booking booking = this.bookingService.createBooking(bookingDto);
        if (booking != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created booking!!",booking));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to create the booking!!!", null));
    }

}
