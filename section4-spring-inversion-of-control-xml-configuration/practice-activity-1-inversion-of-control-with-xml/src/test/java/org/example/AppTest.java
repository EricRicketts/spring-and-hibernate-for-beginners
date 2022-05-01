package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.BaseballCoach;
import org.example.model.Coach;
import org.example.model.PickleballCoach;
import org.example.model.TrackCoach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest {
    private String expected;
    private ApplicationContext context;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testCoachInterfaceWithBaseballCoachClass() {
        Coach theCoach = context.getBean("baseballCoach", BaseballCoach.class);
        expected = "Spend 30 minutes on batting practice";
        assertEquals(expected, theCoach.getDailyWorkout());
    }

    @Test
    public void testCoachInterfaceWithTrackCoachClass() {
        Coach theCoach = context.getBean("trackCoach", TrackCoach.class);
        expected = "Run a hard 5k";
        assertEquals(expected, theCoach.getDailyWorkout());
    }

    @Test
    public void testCoachInterfaceWithPickleballCoachClass() {
        Coach theCoach = context.getBean("pickleballCoach", PickleballCoach.class);
        expected = "30 minutes of dinking practice.";
        assertEquals(expected, theCoach.getDailyWorkout());
    }

}
