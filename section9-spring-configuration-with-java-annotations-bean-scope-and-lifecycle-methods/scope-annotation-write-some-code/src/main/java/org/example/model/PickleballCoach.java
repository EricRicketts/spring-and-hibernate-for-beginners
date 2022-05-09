package org.example.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PickleballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice third shot drops for 30 minutes.";
    }
}
