package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${eric.team}")
    private String team;
    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 5x200 on 2:30.";
    }
}
