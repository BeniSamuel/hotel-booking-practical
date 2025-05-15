package com.hotel.ishimwe_hirwa.service;

import com.hotel.ishimwe_hirwa.dto.BookingDto;
import com.hotel.ishimwe_hirwa.model.Booking;
import com.hotel.ishimwe_hirwa.model.Rooms;
import com.hotel.ishimwe_hirwa.model.User;
import com.hotel.ishimwe_hirwa.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final RoomsService roomsService;

    public BookingService (BookingRepository bookingRepository, UserService userService, RoomsService roomsService) {
        this.bookingRepository = bookingRepository;
        this.roomsService = roomsService;
        this.userService = userService;
    }

    public Booking createBooking (BookingDto bookingDto) {
        Rooms rooms = this.roomsService.getRoomById(bookingDto.getRoom_id());
        User user = this.userService.getUserById(bookingDto.getUser_id());

        if (rooms != null && user != null) {
            Booking newBoooking = new Booking(user, rooms, bookingDto.isCheck_in(), bookingDto.isCheck_out(), bookingDto.getStatus());
            return this.bookingRepository.save(newBoooking);
        }
        return null;
    }

    public List<Booking> getBookingByUser (Long id) {
        User user = this.userService.getUserById(id);
        if (user != null) {
            return this.bookingRepository.getBookingsByUser(user);
        }
        return null;
    }

    public boolean deleteBookings (Long id) {
        Booking booking = this.bookingRepository.getBookingsById(id);
        if (booking != null) {
            this.bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
