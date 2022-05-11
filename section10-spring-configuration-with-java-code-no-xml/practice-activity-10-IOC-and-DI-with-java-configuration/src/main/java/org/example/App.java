package org.example;

import org.example.config.ProjectConfig;
import org.example.model.SwimCoach;
import org.example.model.TennisCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getEmail() + "\n" + tennisCoach.getDailyFortune());
        System.out.println(swimCoach.getTeam() + "\n" + swimCoach.getDailyFortune());
    }
}
