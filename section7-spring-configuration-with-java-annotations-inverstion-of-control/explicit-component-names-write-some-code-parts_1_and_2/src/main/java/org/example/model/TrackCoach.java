package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value="trackCoach")
public class TrackCoach implements Coach {

    private static String classStatement;
    private String statement;
    private FortuneService fortuneService;

    @Autowired
    public TrackCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    public static String getClassStatement() {
        return classStatement;
    }

    public static void setClassStatement(String newClassStatement) {
        classStatement = newClassStatement;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    @PreDestroy
    public void doMyCleanUpStuff() {
        setClassStatement("in doMyCleanUpStuff");
    }

    @PostConstruct
    public void doMyStartUpStuff() {
        setStatement("in doMyStartUpStuff");
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
