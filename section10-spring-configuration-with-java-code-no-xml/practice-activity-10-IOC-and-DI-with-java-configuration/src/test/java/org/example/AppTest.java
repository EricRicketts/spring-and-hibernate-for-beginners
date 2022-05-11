package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.config.ProjectConfig;
import org.example.model.TennisCoach;
import org.example.model.SwimCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

    ApplicationContext context;
    SwimCoach swimCoach;
    TennisCoach tennisCoach;
    String[] expected;
    String[] results;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        swimCoach = context.getBean("swimCoach", SwimCoach.class);
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
    }
    @Test
    public void testSwimCoach() {
        expected = new String[]{"Swim 5x200 on 2:30.", "Today is your luck day!", "The Marlins"};
        results = new String[]{swimCoach.getDailyWorkout(), swimCoach.getDailyFortune(), swimCoach.getTeam()};
        assertArrayEquals(expected, results);
    }

    @Test
    public void testTennisCoach() {
        expected = new String[]{"Practice backhands for 30 minutes.",
                "You will die alone and poorly dressed.", "eric_ricketts@icloud.com"};
        results = new String[]{tennisCoach.getDailyWorkout(), tennisCoach.getDailyFortune(), tennisCoach.getEmail()};
        assertArrayEquals(expected, results);
    }
}
