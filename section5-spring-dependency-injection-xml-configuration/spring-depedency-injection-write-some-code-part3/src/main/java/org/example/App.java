package org.example;

import org.example.model.BaseballCoach;
import org.example.model.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);
        TrackCoach trackCoach = context.getBean("trackCoach", TrackCoach.class);
        String output = baseballCoach.getDailyWorkout() + "\n" + baseballCoach.getDailyFortune() + "\n"
                + trackCoach.getDailyWorkout() + "\n" + trackCoach.getDailyFortune();
        System.out.println(output);
    }
}
