package com.example.map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lng;
    private String description;

    public Marker() {}

    public Marker(double lat, double lng, String description) {
        this.lat = lat;
        this.lng = lng;
        this.description = description;
    }

    public Long getId() { return id; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setLat(double lat) { this.lat = lat; }
    public void setLng(double lng) { this.lng = lng; }
    public void setDescription(String description) { this.description = description; }
}
