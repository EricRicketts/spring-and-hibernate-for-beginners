package org.example.services;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You will die alone and poorly dressed.";
    }
}
