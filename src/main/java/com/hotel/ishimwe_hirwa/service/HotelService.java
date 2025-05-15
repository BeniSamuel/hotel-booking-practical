package com.hotel.ishimwe_hirwa.service;

import com.hotel.ishimwe_hirwa.dto.HotelDto;
import com.hotel.ishimwe_hirwa.model.Hotel;
import com.hotel.ishimwe_hirwa.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService (HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel (HotelDto hotelDto) {
        Hotel newHotel = new Hotel(hotelDto.getName(), hotelDto.getLocation());
        return this.hotelRepository.save(newHotel);
    }

    public List<Hotel> getAllHotels () {
        return this.hotelRepository.findAll();
    }

    public Hotel getHotelById (Long id) {
        return this.hotelRepository.getHotelById(id).orElse(null);
    }
}
