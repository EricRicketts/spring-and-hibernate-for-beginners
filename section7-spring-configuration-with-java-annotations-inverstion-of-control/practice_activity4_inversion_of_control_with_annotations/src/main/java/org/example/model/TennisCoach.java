package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley for 30 minutes.";
    }
}
