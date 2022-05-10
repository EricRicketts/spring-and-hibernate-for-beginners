package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.config.ProjectConfig;
import org.example.model.TennisCoach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

    ApplicationContext context;
    String[] expectedFortunes;
    String expected;
    TennisCoach tennisCoach;
    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        expectedFortunes = new String[]{"Today is your lucky day.", "Never give up.",
                "Beware of the wolf.", "An apple a day keeps the doctor away.",
                "A bird in hand is better than two in a bush."};
    }

    @Test
    public void testDailyWorkoutFromTennisCoach() {
        expected = "Practice backhand volleys for 30 minutes.";
        assertEquals(expected, tennisCoach.getDailyWorkout());
    }

    @Test
    public void testDailyFortuneFromTennisCoach() {
        List<String> expectedList = Arrays.asList(expectedFortunes);
        boolean listContainsFortune = expectedList.contains(tennisCoach.getDailyFortune());
        assertTrue(listContainsFortune);
    }
}
