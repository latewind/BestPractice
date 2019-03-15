package com.latewind.test.source;

import com.latewind.pattern.behavioral.command.Invoker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {

    @Test
    public void testGetBean() {
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        Invoker invoker = factory.getBean("invoker", Invoker.class);
        Assert.assertNotNull(invoker);
    }
}
