package com.hotel.ishimwe_hirwa.model;

import jakarta.persistence.*;

@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotels_id")
    private Hotel hotel;
    private String room_type;
    private Double price;
    private boolean is_available;

    // Constructor
    public Rooms () {}
    public Rooms (Hotel hotel, String room_type, Double price, boolean is_available) {
        this.hotel = hotel;
        this.room_type = room_type;
        this.price = price;
        this.is_available = is_available;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Hotel getHotels() {
        return hotel;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHotels(Hotel hotels) {
        this.hotel = hotels;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
