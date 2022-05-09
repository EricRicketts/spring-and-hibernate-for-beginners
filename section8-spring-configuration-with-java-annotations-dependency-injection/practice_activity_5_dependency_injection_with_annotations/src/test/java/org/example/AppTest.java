package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.example.model.TennisCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

    ApplicationContext context;
    TennisCoach tennisCoach;
    String[] expected;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        expected = new String[]{"luck favors the brave", "he who will not risk cannot win",
                "the fear of god is the beginning of wisdom"};
    }
    @Test
    public void testRandomFortuneForTennisCoach() {
        String fortune = tennisCoach.getDailyFortune();
        List<String> fortuneList = Arrays.asList(expected);
        assertTrue(fortuneList.contains(fortune));
    }
}
