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

import java.util.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
public class AppTest {

    ApplicationContext context;
    String[] expectedFortunes;
    TennisCoach tennisCoach;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
        expectedFortunes = new String[]{"Today is your lucky day.", "Never give up.",
                "Beware of the wolf.", "An apple a day keeps the doctor away.",
                "A bird in hand is better than two in a bush."};
    }
    @Test
    public void testTennisCoachGivesFortunes() {
        List<String> fortuneResults = new ArrayList<>();
        while (fortuneResults.size() < 5) {
            String fortune = tennisCoach.getDailyFortune();
            if (!fortuneResults.contains(fortune)) fortuneResults.add(fortune);
        }
        Set<String> expectedSet = new HashSet<>();
        Collections.addAll(expectedSet, expectedFortunes);
        Set<String> resultSet = new HashSet<>();
        String[] resultArray = new String[fortuneResults.size()];
        Collections.addAll(resultSet, fortuneResults.toArray(resultArray));
        assertEquals(expectedSet, resultSet);
    }
}
