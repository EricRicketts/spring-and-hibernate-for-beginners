package org.example;

import org.example.config.ProjectConfig;
import org.example.model.JavaCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ProjectConfig.class);
        JavaCoach javaCoach = context.getBean("javaCoach", JavaCoach.class);
        String text = javaCoach.getDailyCodeKata() + "\n" + javaCoach.getEmail() + "\n" + javaCoach.getTeam();
        System.out.println(text);
    }
}
