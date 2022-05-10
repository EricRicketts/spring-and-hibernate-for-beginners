package org.example.config;

import org.example.model.JavaCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ProjectConfig {

    @Bean
    public JavaCoach javaCoach() {
        return new JavaCoach();
    }
}
