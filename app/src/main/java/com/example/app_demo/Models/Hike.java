package com.example.app_demo.Models;

import java.io.Serializable;

public class Hike implements Serializable {
    private int id;

    private String name;

    private String location;

    private String dateOfTheHike;

    private boolean parkingAvailable;

    private int lengthOfTheHike;

    private String difficultLevel;

    private String description;


    public Hike(int id, String name, String location, String dateOfTheHike, boolean parkingAvailable, int lengthOfTheHike, String difficultLevel, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.dateOfTheHike = dateOfTheHike;
        this.parkingAvailable = parkingAvailable;
        this.lengthOfTheHike = lengthOfTheHike;
        this.difficultLevel = difficultLevel;
        this.description = description;
    }

    public Hike(String name, String location, String dateOfTheHike, boolean parkingAvailable, int lengthOfTheHike, String difficultLevel, String description) {
        this.name = name;
        this.location = location;
        this.dateOfTheHike = dateOfTheHike;
        this.parkingAvailable = parkingAvailable;
        this.lengthOfTheHike = lengthOfTheHike;
        this.difficultLevel = difficultLevel;
        this.description = description;
    }

    public Hike() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfTheHike() {
        return dateOfTheHike;
    }

    public void setDateOfTheHike(String dateOfTheHike) {
        this.dateOfTheHike = dateOfTheHike;
    }

    public boolean isParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public int getLengthOfTheHike() {
        return lengthOfTheHike;
    }

    public void setLengthOfTheHike(int lengthOfTheHike) {
        this.lengthOfTheHike = lengthOfTheHike;
    }

    public String getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(String difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
