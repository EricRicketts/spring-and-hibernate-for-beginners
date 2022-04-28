package org.example;

import org.example.model.BaseballCoach;
import org.example.model.Coach;
import org.example.model.TrackCoach;

public class App {
    public static void main( String[] args ) {
        Coach firstCoach = new BaseballCoach();
        Coach secondCoach = new TrackCoach();
        System.out.println(firstCoach.getDailyWorkout() + " " + secondCoach.getDailyWorkout());
    }
}
/*
    This is nice as we "code to the interface" in that we can swap out coaches to meet our requirements, however,
    we have to manually swap coaches it would be nicer if we could have a configuration file that does this for
    us.  Essentially, this is what the Spring Inversion of Control Container does for us.
*/
