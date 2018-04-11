package com.spring;

import com.spring.injection.InjectRandomBeanPostProcessor;
import com.spring.quoters.AnotherQuoter;
import com.spring.quoters.Quoter;
import com.spring.quoters.TerminatorQuoter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HelloWorldConfiguration implements BeanPostProcessor {

    @Bean(name = "injector")
    public InjectRandomBeanPostProcessor injectRandomBeanPostProcessor() {
        return new InjectRandomBeanPostProcessor();
    }

    @Bean(name = "termQuot")
    public Quoter myTerminatorQuoter() {
        return new TerminatorQuoter();
    }

    @Bean(name = "anoQout")
    public Quoter myAnotherQuoter() {
        return new AnotherQuoter();
    }
}
