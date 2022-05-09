package org.example.model;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    private String instanceStatement;
    private static String staticStatement;
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volleys for 30 minutes.";
    }

    public String getInstanceStatement() {
        return instanceStatement;
    }

    public static String getStaticStatement() {
        return staticStatement;
    }

    public void setInstanceStatement(String instanceStatement) {
        this.instanceStatement = instanceStatement;
    }

    public static void setStaticStatement(String staticStatement) {
        TennisCoach.staticStatement = staticStatement;
    }

    @PostConstruct
    public void init() {
        setInstanceStatement("I have set the instanceStatement variable after the bean was created.");
    }

    @PreDestroy
    public void cleanUp() {
        TennisCoach.setStaticStatement("I have set the staticStatement variable after the bean was destroyed.");
    }
}
