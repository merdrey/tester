package ru.bmstu.tester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bmstu.Main;
import ru.bmstu.parser.impl.ParserImpl;
import ru.bmstu.user.User;

@Component
public class Tester {
    @Autowired
    private ParserImpl pars;
    @Autowired
    private User user;
    private boolean[] userAnswers = new boolean[6];
    public Tester() {
        init();
    }
    private void init() {
        System.out.println("Welcome to the test system!");
    }
    private void answersOutput(String[] answers) {
        for(int i = 0; i < answers.length; i++) {
            System.out.println(i + 1 + ". " + answers[i]);
        }
    }
    public void loop() {
        for(int i = 0; i < pars.getQuestions().size(); i++){
            System.out.println(pars.getQuestions().get(i));
            answersOutput(pars.getAnswers().get(i));
            user.getUserAns().add(Main.scan.next());
            userAnswers[i] = user.getUserAns().get(i).equals(pars.getCorrectAnswers().get(i));
        }
    }
    public void result() {
        System.out.println();
        int count = 0;
        for(int i = 0; i < userAnswers.length; i++) {
            if(userAnswers[i]) {
                count++;
                System.out.println("\u001B[32m" + user.getUserAns().get(i) + "\u001B[0m");
            }
            else {
                System.out.println("\u001B[31m" + user.getUserAns().get(i) + "\u001B[0m");
            }
        }
        if(count >= 3) {
            System.out.println("You have passed the test!");
        }
        else {
            System.out.println("You have not passed the test!");
        }
    }
}
