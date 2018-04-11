package com.spring.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

public class InjectRandomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        int value;
        for (Field field : fields) {
            InjectRandom injectRandom = field.getAnnotation(InjectRandom.class);
            if (injectRandom != null) {
                Random random = new Random();
                value = injectRandom.min() + random.nextInt(injectRandom.max() - injectRandom.min());
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
