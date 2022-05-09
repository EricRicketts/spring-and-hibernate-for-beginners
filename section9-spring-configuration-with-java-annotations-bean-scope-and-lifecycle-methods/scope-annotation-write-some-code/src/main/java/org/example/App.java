package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.model.TennisCoach;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        TennisCoach secondTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach == secondTennisCoach);
    }
}
