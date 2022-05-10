package org.example.model;

import org.springframework.beans.factory.annotation.Value;

public class JavaCoach implements Coach {

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyCodeKata() {
        return "Work on LeetCode problems for 2 hours.";
    }
}
