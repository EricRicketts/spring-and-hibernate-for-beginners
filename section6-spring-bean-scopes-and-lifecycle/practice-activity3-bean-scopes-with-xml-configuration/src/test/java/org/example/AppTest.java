package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.PickleBallCoach;
import org.example.model.TrackCoach;
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

    String expected;
    @Test
    public void testInitMethodsRunOnBean() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);
        expected = "in doMyStartUpStuff";
        assertEquals(expected, coach.getStatement());
    }

    @Test
    public void testDestroyMethodsRunOnBean() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);
        context.close();
        expected = "in doMyCleanUpStuff";
        assertEquals(expected, TrackCoach.getClassStatement());
    }

    @Test
    public void testPrototypeScope() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        TrackCoach trackCoachOne = context.getBean("trackCoach", TrackCoach.class);
        TrackCoach trackCoachTwo = context.getBean("trackCoach", TrackCoach.class);
        PickleBallCoach pickleBallCoachOne = context.getBean("pickleBallCoach", PickleBallCoach.class);
        PickleBallCoach pickleBallCoachTwo = context.getBean("pickleBallCoach", PickleBallCoach.class);
        boolean[] expectedArray = new boolean[]{true, true};
        boolean[] resultArray = new boolean[]{(trackCoachOne == trackCoachTwo),
                (pickleBallCoachOne != pickleBallCoachTwo)};
        assertArrayEquals(expectedArray, resultArray);
    }
}
