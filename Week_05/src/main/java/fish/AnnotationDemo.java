package src.main.java.fish;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("annotationBean.xml");

        Box box = (Box)context.getBean("box");

        box.showBox();

    }
}
