package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bmstu.myconfig.MyConfig;
import ru.bmstu.parser.impl.ParserImpl;

public class TestParser {
    private ParserImpl pars;
    @BeforeEach
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        pars = context.getBean(ParserImpl.class);
        pars.setResource(context.getResource(ParserImpl.PATH));
    }

    @Test
    public void ParserImplLoadFileTest(){
        Assertions.assertNotNull(pars.getAnswers());
        Assertions.assertNotNull(pars.getQuestions());
        Assertions.assertNotNull(pars.getCorrectAnswers());
    }

}
