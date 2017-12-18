package com.example.sam.burrito_builder;

/**
 * Created by Sam on 12/17/17.
 */

public class burritoLocation {
    private String location;
    private String website;

    private void setLocationInfo(Integer burritoLocation){
        switch (burritoLocation){
            case 0:
                location = "Illegal Petes";
                website = "http://illegalpetes.com/";
                break;
            case 1:
                location = "Centro";
                website = "https://www.centromexican.com/";
                break;
            case 2:
                location = "Chipotle";
                website = "https://www.chipotle.com";
        }
    }

    public void setLocation(Integer burritoLocaation){
        setLocationInfo(burritoLocaation);
    }
    public void setWebsite(Integer burritoLocation){
        setLocationInfo(burritoLocation);
    }

    public String getLocation(){
        return location;
    }
    public String getWebsite(){
        return website;
    }
}
