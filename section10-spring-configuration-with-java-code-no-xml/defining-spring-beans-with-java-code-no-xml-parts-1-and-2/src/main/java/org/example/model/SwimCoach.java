package org.example.model;

import org.example.services.FortuneService;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 5x200 on 2:30";
    }
}
