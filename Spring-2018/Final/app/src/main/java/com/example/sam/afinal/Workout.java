package com.example.sam.afinal;

/**
 * Created by Sam on 5/6/18.
 */

public class Workout {
    private String name;

    public Workout(String name) {
        this.name = name;
    }

    public static final Workout[] Cardio = {
            new Workout("Treadmill"),
            new Workout("Elliptical"),
            new Workout("Stair Climber")
    };

    public static final Workout[] Strength = {
            new Workout("Push-Up"),
            new Workout("Squat"),
            new Workout("Dumbbell Row")
    };
    public static final Workout[] Flexibility = {
            new Workout("Arm Across Chest"),
            new Workout("Triceps Stretch"),
            new Workout("Glute Stretch")
    };

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name;
    }
}
