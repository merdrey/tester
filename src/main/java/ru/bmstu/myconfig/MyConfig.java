package ru.bmstu.myconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.bmstu.parser")
@ComponentScan("ru.bmstu.tester")
@ComponentScan("ru.bmstu.user")
public class MyConfig {

}
