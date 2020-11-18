package src.main.java.fish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Box {

    @Autowired
    Book book;

    @Autowired
    LifeBook lifeBook;

    public void showBox() {
        book.show();
        lifeBook.show();
    }
}
