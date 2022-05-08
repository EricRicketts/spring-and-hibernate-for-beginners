package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.TennisCoach;
import org.example.services.HappyFortuneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

    ApplicationContext context;
    HappyFortuneService happyFortuneService;
    TennisCoach tennisCoach;
    String expected;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        happyFortuneService = context.getBean("happyFortuneService", HappyFortuneService.class);
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
    }

    @Test
    public void testHappyFortuneServiceScanned() {
        expected = "Today is your lucky day!";
        assertEquals(expected, happyFortuneService.getFortune());
    }

    @Test
    public void testTennisCoachScanned() {
        expected = "Practice backhand volleys for 30 minutes.";
        assertEquals(expected, tennisCoach.getDailyWorkout());
    }

    @Test
    public void testTennisCoachConstructorInjection() {
        expected = "Today is your lucky day!";
        assertEquals(expected, tennisCoach.getDailyFortune());
    }
}
