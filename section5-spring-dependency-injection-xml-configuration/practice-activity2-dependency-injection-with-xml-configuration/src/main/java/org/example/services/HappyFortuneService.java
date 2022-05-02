package org.example.services;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    private final String[] fortunes = new String[]{
            "Today is your lucky day!", "A faithful friend is a strong defense.",
            "A fresh start will put you on your way."
    };
    @Override
    public String getFortune() {
        Random rn = new Random();
        return fortunes[rn.nextInt(3)];
    }
}
