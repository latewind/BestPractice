package com.latewind.pattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MapperProxy<T> implements InvocationHandler {
    private HashMap<Method, MapperMethod> methodCache;

    public MapperProxy(HashMap<Method, MapperMethod> methodCache) {
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoke begin MapperProxy");
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            MapperMethod mapperMethod = methodCache.get(method);
            return mapperMethod.execte(args);
        }
    }


}
