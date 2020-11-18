package src.main.java.fish;

import java.util.List;

public class User {
    private String username;
    private Integer password;
    private List list;
    /**
     * 1.使用构造注入
     * 1.1提供带所有参数的有参构造方法。
     /
     public fish.User(String username, Integer password, List list) {
     super();
     this.username = username;
     this.password = password;
     this.list = list;
     }
     /*
     * 2.使用设值注入
     * 2.1提供默认空参构造方法 ;
     * 2.2为所有属性提供setter方法。
     */
    public User() {
        super();
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }
    public void setList(List list) {
        this.list = list;
    }
    @Override
    public String toString() {
        return "fish.User [username=" + username + ", password=" + password +
", list="+ list + "]";
    }
}