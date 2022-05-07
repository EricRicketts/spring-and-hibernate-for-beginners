package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.PickleBallCoach;
import org.example.model.TennisCoach;
import org.example.model.TrackCoach;
import org.example.model.UniqueCoach;
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
    public void testDefaultComponentName() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UniqueCoach coach = context.getBean("uniqueCoach", UniqueCoach.class);
        expected = "Elmer Fudd";
        coach.setName("Elmer Fudd");
        assertEquals(expected, coach.getName());
    }

}
