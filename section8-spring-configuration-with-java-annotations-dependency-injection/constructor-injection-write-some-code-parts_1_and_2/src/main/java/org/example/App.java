package org.example;

import org.example.model.TennisCoach;
import org.example.services.HappyFortuneService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyFortuneService happyFortuneService =
                context.getBean("happyFortuneService", HappyFortuneService.class);
        System.out.println(happyFortuneService.getFortune());
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getDailyWorkout() + "\n" + tennisCoach.getDailyFortune());
    }
}
