package com.spring;

import com.spring.quoters.Quoter;
import com.spring.quoters.TerminatorQuoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        Quoter quoter = (TerminatorQuoter) applicationContext.getBean("termQuot");
        quoter.saySmth();
        }
    }

