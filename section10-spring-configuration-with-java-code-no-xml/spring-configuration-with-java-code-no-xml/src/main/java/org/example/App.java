package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.config.ProjectConfig;
import org.example.model.TennisCoach;

public class App {
    public static void main( String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ProjectConfig.class);
        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(tennisCoach.getDailyFortune());
    }
}
