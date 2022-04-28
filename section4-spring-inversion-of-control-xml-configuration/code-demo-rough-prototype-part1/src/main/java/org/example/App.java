package org.example;

import org.example.model.BaseballCoach;
import org.example.model.Coach;

public class App {
    public static void main( String[] args ) {
        Coach theCoach = new BaseballCoach();
        System.out.println(theCoach.getDailyWorkout());
    }
}
