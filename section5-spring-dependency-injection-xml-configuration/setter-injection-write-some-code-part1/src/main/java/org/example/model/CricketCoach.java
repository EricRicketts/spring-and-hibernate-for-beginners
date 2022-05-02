package org.example.model;

import org.example.services.FortuneService;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    public CricketCoach() { super(); }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
