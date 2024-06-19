package ru.bmstu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bmstu.myconfig.MyConfig;
import ru.bmstu.parser.impl.ParserImpl;
import ru.bmstu.tester.Tester;
import ru.bmstu.user.User;

import java.util.Scanner;


public class Main {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        ParserImpl parser = context.getBean(ParserImpl.class);
        Tester tester = context.getBean(Tester.class);
        User user = context.getBean(User.class);
        parser.setResource(context.getResource(ParserImpl.PATH));
        parser.read();
        user.setName();
        tester.loop();
        tester.result();
    }
}