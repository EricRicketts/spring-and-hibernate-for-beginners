package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volleys for 30 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
