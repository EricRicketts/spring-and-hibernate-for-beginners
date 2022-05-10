package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.model.TennisCoach;
import org.example.model.SwimCoach;
import org.example.config.ProjectConfig;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(tennisCoach.getDailyFortune() + "\n" + tennisCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune() + "\n" + swimCoach.getDailyWorkout());
    }
}
