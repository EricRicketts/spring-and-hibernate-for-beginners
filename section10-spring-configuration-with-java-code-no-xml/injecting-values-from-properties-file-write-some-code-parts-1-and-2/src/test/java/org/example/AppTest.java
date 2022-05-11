package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.config.ProjectConfig;
import org.example.model.JavaCoach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTest {

    ApplicationContext context;
    JavaCoach javaCoach;
    String[] expected;
    String[] results;
    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        javaCoach = context.getBean("javaCoach", JavaCoach.class);
    }
    @Test
    public void testLoadPropertiesFromFile() {
        expected = new String[]{"eric_ricketts@icloud.com", "New To Java"};
        results = new String[]{javaCoach.getEmail(), javaCoach.getTeam()};
        assertArrayEquals(expected, results);
    }
}
