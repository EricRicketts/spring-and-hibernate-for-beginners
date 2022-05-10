package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class RandomFortuneService implements FortuneService {

    private String filename = "fortune-data.txt";
    private List<String> fortunes;
    private Random randomNumber;

    @Autowired
    public RandomFortuneService() {
        this.randomNumber = new Random();
    }

    @PostConstruct
    public void init() {
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            inputStream = new FileInputStream(file);
            String text = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.joining("\n"));
            fortunes = Arrays.asList(text.split("\n"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public String getFortune() {
        int index = randomNumber.nextInt(fortunes.size());
        String fortune = fortunes.get(index);
        return fortune;
    }
}
