package org.example.config;

import org.example.model.SwimCoach;
import org.example.model.TennisCoach;
import org.example.services.HappyFortuneService;
import org.example.services.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    public SwimCoach swimCoach(SadFortuneService fortuneService) {
        return new SwimCoach(fortuneService);
    }

    @Bean
    public TennisCoach tennisCoach(HappyFortuneService fortuneService) {
        return new TennisCoach(fortuneService);
    }
}
