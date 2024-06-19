package ru.bmstu.user;

import org.springframework.stereotype.Component;
import ru.bmstu.Main;

import java.util.ArrayList;

@Component
public class User {
    private String name, surname;
    private ArrayList<String> userAns = new ArrayList<>();
    public void setName() {
        System.out.println("Enter your name");
        name = Main.scan.next();
        System.out.println("Enter your surname");
        surname = Main.scan.next();
    }
    public ArrayList<String> getUserAns() {
        return userAns;
    }
}
