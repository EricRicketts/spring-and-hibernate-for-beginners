package org.example.model;

import org.example.services.FortuneService;

public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhands for 30 minutes.";
    }
}
