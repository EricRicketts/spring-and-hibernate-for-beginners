package org.example.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volleys for 30 minutes.";
    }
}
