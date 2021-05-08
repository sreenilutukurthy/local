package com.digitalskills.dvla.model;

public class Vehicle {

    private final String regNumber;
    private final String make;
    private final String colour;
    private final double year;

    public Vehicle(String regNumber, String make, String colour, double year) {
        this.regNumber = regNumber;
        this.make = make;
        this.colour = colour;
        this.year = year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getMake() {
        return make;
    }

    public String getColour() {
        return colour;
    }

    public double getYear() {
        return year;
    }

}
