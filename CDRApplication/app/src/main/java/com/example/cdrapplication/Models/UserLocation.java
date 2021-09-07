package com.example.cdrapplication.Models;

public class UserLocation {
   private String locationName;
   private int frequency;

    public UserLocation() {
    }

    public UserLocation(String locationName, int frequency) {
        this.locationName = locationName;
        this.frequency = frequency;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

