package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.config.ProjectConfig;
import org.example.model.SwimCoach;
import org.example.model.TennisCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    ApplicationContext context;
    TennisCoach tennisCoach;
    SwimCoach swimCoach;
    String[] expected;
    String[] results;
    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        swimCoach = context.getBean("swimCoach", SwimCoach.class);
    }

    @Test
    public void testTennisCoachBean() {
        expected = new String[]{"Practice backhands for 30 minutes.", "Today is your lucky day!"};
        results = new String[]{tennisCoach.getDailyWorkout(), tennisCoach.getDailyFortune()};
        assertArrayEquals(expected, results);
    }

    @Test
    public void testSwimCoachBean() {
        expected = new String[]{"Swim 5x200 on 2:30", "You will die alone and poorly dressed."};
        results = new String[]{swimCoach.getDailyWorkout(), swimCoach.getDailyFortune()};
        assertArrayEquals(expected, results);
    }
}
