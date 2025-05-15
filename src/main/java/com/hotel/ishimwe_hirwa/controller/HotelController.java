package com.hotel.ishimwe_hirwa.controller;

import com.hotel.ishimwe_hirwa.dto.HotelDto;
import com.hotel.ishimwe_hirwa.model.Hotel;
import com.hotel.ishimwe_hirwa.service.HotelService;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/v1/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController (HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Hotel>>> getAllHotels () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained hotels!!! 🎉🎉🎉", this.hotelService.getAllHotels()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Hotel>> getHotelById (@PathVariable Long id) {
        Hotel hotel = this.hotelService.getHotelById(id);
        if (hotel != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained hotel!!! 🎉🎉🎉", hotel));
        }
        return ResponseEntity.ok(new ApiResponse<>(false, "Failed to obtain hotel!!! 💔💔💔", null));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Hotel>> createHotel (@RequestBody HotelDto hotelDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created a hotel!!! 🎉🎉🎉", this.hotelService.createHotel(hotelDto)));
    }
}
