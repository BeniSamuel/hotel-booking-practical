package com.hotel.ishimwe_hirwa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    // Constructor used to initialize instance non-parameterized and parameterized
    public Hotel () {}
    public Hotel (String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters Used
    public Long getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String getLocation () {
        return this.location;
    }

    // Setters Used
    public void setName (String name) {
        this.name = name;
    }

    public void setLocation (String location) {
        this.location = location;
    }


}
