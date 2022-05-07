package org.example.services;

import org.springframework.stereotype.Component;

@Component(value="myFortuneService")
public class MyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
