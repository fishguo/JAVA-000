package src.main.java.fish;

import org.springframework.stereotype.Component;

@Component
public class LifeBook extends Book {

    @Override
    public void show() {
        System.out.println("Life's Book");
    }
}
