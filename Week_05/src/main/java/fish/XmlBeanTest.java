package src.main.java.fish;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanTest {
    public static void main(String[] args) {

        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beandemo.xml");
        // 构造方式输出结果
        System.out.println(applicationContext.getBean("user1"));
        // 设值方式输出结果
        System.out.println(applicationContext.getBean("user2"));
    }
}
