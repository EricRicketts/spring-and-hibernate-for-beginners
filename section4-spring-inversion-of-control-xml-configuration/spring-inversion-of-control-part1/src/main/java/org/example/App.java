package org.example;

import java.net.URL;
import java.net.URLClassLoader;
import org.example.model.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("trackCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        URL[] urls = ((URLClassLoader)cl).getURLs();
        String s = String.valueOf(cl.getParent());
        System.out.println(s);
    }
}