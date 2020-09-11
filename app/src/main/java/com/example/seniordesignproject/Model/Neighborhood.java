package com.example.seniordesignproject.Model;

public class Neighborhood {

    String id;
    String neighborhoodName;

    public Neighborhood(String id, String neighborhoodName) {
        this.id = id;
        this.neighborhoodName = neighborhoodName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public Neighborhood() {

    }
}
