package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.PickleballCoach;
import org.example.model.TennisCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

    ApplicationContext context;
    TennisCoach tennisCoach;
    PickleballCoach pickleballCoach;

    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        pickleballCoach = context.getBean("pickleballCoach", PickleballCoach.class);
    }

    @Test
    public void testTennisCoachIsSingleton() {
        TennisCoach secondTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        assertTrue(tennisCoach == secondTennisCoach);
    }

    @Test
    public void testPickleballCoachIsPrototype() {
        PickleballCoach secondPickleballCoach = context.getBean("pickleballCoach", PickleballCoach.class);
        assertNotSame(pickleballCoach, secondPickleballCoach);
    }
}
