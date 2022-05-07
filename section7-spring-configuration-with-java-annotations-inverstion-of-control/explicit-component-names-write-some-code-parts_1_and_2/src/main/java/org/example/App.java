package org.example;

import org.example.model.PickleBallCoach;
import org.example.model.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);
        PickleBallCoach pCoachOne = context.getBean("pickleBallCoach", PickleBallCoach.class);
        PickleBallCoach pCoachTwo = context.getBean("pickleBallCoach", PickleBallCoach.class);
        System.out.println(coach.getDailyWorkout() + "\n" + coach.getDailyFortune());
        System.out.println(coach.getStatement());
        System.out.println(pCoachOne == pCoachTwo);
        context.close();
        System.out.println(TrackCoach.getClassStatement());
    }
}
