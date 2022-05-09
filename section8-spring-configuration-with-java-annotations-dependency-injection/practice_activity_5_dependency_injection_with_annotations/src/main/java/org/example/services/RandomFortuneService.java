package org.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    @Value("${fortunes}")
    String[] fortunes;
    Random randomNumber = new Random();
    @Override
    public String getFortune() {
        int index = randomNumber.nextInt(fortunes.length);
        String fortune = fortunes[index];
        return fortune;
    }
}
