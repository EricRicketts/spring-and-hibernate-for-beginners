package org.example.config;

import org.example.model.SwimCoach;
import org.example.model.TennisCoach;
import org.example.services.HappyFortuneService;
import org.example.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ProjectConfig {

    @Bean
    public HappyFortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

    @Bean
    public SadFortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public SwimCoach swimCoach(HappyFortuneService happyFortuneService) {
        return new SwimCoach(happyFortuneService);
    }

    @Bean
    public TennisCoach tennisCoach(SadFortuneService sadFortuneService) {
        return new TennisCoach(sadFortuneService);
    }
}
