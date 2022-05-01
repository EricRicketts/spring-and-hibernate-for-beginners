package org.example;

import org.example.model.BaseballCoach;
import org.example.model.Coach;
import org.example.model.PickleballCoach;
import org.example.model.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("trackCoach", TrackCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        theCoach = context.getBean("baseballCoach", BaseballCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        theCoach = context.getBean("pickleballCoach", PickleballCoach.class);
        System.out.println(theCoach.getDailyWorkout());
    }
}