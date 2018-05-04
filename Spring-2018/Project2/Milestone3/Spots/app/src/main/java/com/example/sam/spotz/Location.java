package com.example.sam.spotz;

/**
 * Created by Sam on 5/1/18.
 */

public class Location {
    private String Name;
    private int Photo;

    public Location() {
    }

    public Location(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    //Getter

    public String getName() {
        return Name;
    }

    public int getPhoto() {
        return Photo;
    }

    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
