package com.example.sam.netflix_find;

/**
 * Created by Sam on 4/3/18.
 */

public class shows {
    private String showName;
    private int showImage;

    private shows(String newShow, int newShowImage){
        this.showName = newShow;
        this.showImage = newShowImage;
    }

    public static final shows[] tvshows = {
            new shows("Stranger Things", R.drawable.stranger),
            new shows("Narcos", R.drawable.nar),
            new shows("Master of None", R.drawable.master),
            new shows("The Get Down", R.drawable.getdown)
    };
    public static final shows[] movies = {
            new shows("Talladega Nights", R.drawable.talladega),
            new shows("Forgetting Sarah Marshall", R.drawable.forgetting),
            new shows("Moana", R.drawable.moana),
            new shows("Tropic Thunder", R.drawable.thunder)
    };
    public static final shows[] documentaries = {
            new shows("Dirt Money", R.drawable.dirty),
            new shows("Trump: An American Dream", R.drawable.american),
            new shows("Flint Town", R.drawable.flint),
            new shows("Take Your Pills", R.drawable.pills)
    };

    public String getName(){
        return showName;
    }

    public int getImageID(){
        return showImage;
    }
    public String toString(){
        return this.showName;
    }
}
