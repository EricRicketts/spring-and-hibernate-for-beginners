package org.example;

import org.example.model.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);
        TrackCoach alphaCoach = context.getBean("trackCoach", TrackCoach.class);
        System.out.println(coach.getDailyWorkout() + "\n" + coach.getDailyFortune());
        System.out.println("Coaches should not be the same bean: " + (coach != alphaCoach));
        System.out.println("Memory location for coach: " + coach);
        System.out.println("Memory location for aplpha coach: " + alphaCoach);
    }
}
