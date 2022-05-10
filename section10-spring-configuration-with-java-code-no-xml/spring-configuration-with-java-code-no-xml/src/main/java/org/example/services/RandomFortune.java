package org.example.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortune implements FortuneService {

    private String[] fortunes = new String[]{"Today is your lucky day.", "Never give up.",
            "Beware of the wolf.", "An apple a day keeps the doctor away.",
            "A bird in hand is better than two in a bush."};
    Random randomNumber = new Random();
    @Override
    public String getFortune() {
        int index = randomNumber.nextInt(fortunes.length);
        String fortune = fortunes[index];
        return fortune;
    }
}
