package org.example.model;

import org.example.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="pickleBallCoach")
public class PickleBallCoach implements Coach {

    private FortuneService fortuneService;

    @Autowired
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
