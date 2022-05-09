package org.example.services;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "This is your lucky day!";
    }
}
