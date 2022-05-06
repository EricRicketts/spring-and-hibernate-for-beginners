package org.example.model;

import org.example.services.FortuneService;

public class PickleBallCoach implements Coach {

    private FortuneService fortuneService;

    public PickleBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
    @Override
    public String getDailyWorkout() {
        return "30 minutes of dinking practice";
    }
}
