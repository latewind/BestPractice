package com.latewind.test.pattern;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.latewind.pattern.structural.proxy.dynamic.MapperMethod;
import org.junit.Test;

import com.latewind.pattern.structural.proxy.dynamic.BusinessService;
import com.latewind.pattern.structural.proxy.dynamic.MapperProxyFactory;
import com.latewind.pattern.structural.proxy.dynamic.UserDao;

public class DynamicProxyTest {

    /**
     * use the dynamic proxy mock mybatis proxy dao
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException {
        String userDaoClazz = "com.latewind.pattern.structural.proxy.dynamic.UserDao";
        Class targetClazz = Class.forName(userDaoClazz);
        Method getUserMethod = targetClazz.getMethod("getUser",null);
        HashMap<Method, MapperMethod> methodCache= new HashMap<>();
        methodCache.put(getUserMethod,new MapperMethod());

        MapperProxyFactory<?> factory = new MapperProxyFactory<>();
        Object f = factory.getMapper(targetClazz,methodCache);
        System.out.println(targetClazz.getName());

        UserDao userDao = (UserDao) f;
        BusinessService businessService = BusinessService.class.newInstance();
        Field userfield = businessService.getClass().getField("userDao");
        userfield.setAccessible(true);
        userfield.set(businessService, userDao);
        businessService.getUser();

    }
}
