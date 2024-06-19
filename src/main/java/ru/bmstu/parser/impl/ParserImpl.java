package ru.bmstu.parser.impl;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.bmstu.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class ParserImpl implements Parser {
    public static final String PATH = "qa.csv";
    private Resource resource;
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String[]> answers = new ArrayList<>();
    private ArrayList<String> correctAnswers = new ArrayList<>();
    public void read() {
        try(BufferedReader reader = new BufferedReader(new FileReader(resource.getFile())))
        {
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null)
            {
                questions.add(line.split(";")[0]);
                answers.add(line.substring(line.indexOf(";") + 1, line.lastIndexOf(";") - 2).split(";"));
                correctAnswers.add(line.substring(line.lastIndexOf(";") - 1, line.lastIndexOf(";")));
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public ArrayList<String> getQuestions() {
        return questions;
    }
    public ArrayList<String[]> getAnswers() {
        return answers;
    }
    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
