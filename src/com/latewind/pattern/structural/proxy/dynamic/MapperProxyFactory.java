package com.latewind.pattern.structural.proxy.dynamic;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MapperProxyFactory<T> {

    @SuppressWarnings("unchecked")
    public T getMapper(Class<T> mapperInterface, HashMap<Method, MapperMethod> methodCache) {

        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new MapperProxy<T>(methodCache));
    }
}
