package com.hotel.ishimwe_hirwa.dto;

import com.hotel.ishimwe_hirwa.enums.Status;

public class RoomsDto {
    private Long hotel_id;
    private String room_type;
    private Double price;
    private boolean is_available;

    public Long getHotel_id() {
        return hotel_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public Double getPrice() {
        return price;
    }

    public boolean getIsAvailable() {
        return is_available;
    }
}
