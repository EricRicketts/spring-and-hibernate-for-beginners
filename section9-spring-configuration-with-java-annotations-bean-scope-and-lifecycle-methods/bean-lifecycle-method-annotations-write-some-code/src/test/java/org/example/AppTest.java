package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.TennisCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

    ApplicationContext context;
    TennisCoach tennisCoach;
    String expected;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
    }

    @Test
    public void testPostConstructMethod() {
        expected = "I have set the instanceStatement variable after the bean was created.";
        assertEquals(expected, tennisCoach.getInstanceStatement());
    }

    @Test
    public void testPreDestroyMethod() {
        expected = "I have set the staticStatement variable after the bean was destroyed.";
        ((ConfigurableApplicationContext)context).close();
        assertEquals(expected, TennisCoach.getStaticStatement());
    }
}
