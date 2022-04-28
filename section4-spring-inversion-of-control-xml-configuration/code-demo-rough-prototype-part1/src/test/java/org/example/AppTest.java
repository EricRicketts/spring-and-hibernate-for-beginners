package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.BaseballCoach;
import org.example.model.Coach;
import org.junit.jupiter.api.Test;

public class AppTest {
    String expected;
    @Test
    public void testCoachInterfaceWithBaseballCoachClass() {
        Coach theCoach = new BaseballCoach();
        expected = "Spend 30 minutes on batting practice";
        assertEquals(expected, theCoach.getDailyWorkout());
    }
}
