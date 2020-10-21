package com.example.cssemobileapp.Model;

public class Supplier {
    String contactNumber,email,location,name,userID;
    boolean availability;

    public Supplier(){}

    public Supplier(String contactNumber, String email, String location, String name, String userID, boolean availability) {
        this.contactNumber = contactNumber;
        this.email = email;
        this.location = location;
        this.name = name;
        this.userID = userID;
        this.availability = availability;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
