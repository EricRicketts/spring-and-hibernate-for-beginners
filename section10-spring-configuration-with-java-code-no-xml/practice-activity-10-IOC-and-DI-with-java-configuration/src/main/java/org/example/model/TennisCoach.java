package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class TennisCoach implements Coach {

    @Value("${eric.email}")
    private String email;
    private FortuneService fortuneService;

    public TennisCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    public String getEmail() {
        return email;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhands for 30 minutes.";
    }
}
