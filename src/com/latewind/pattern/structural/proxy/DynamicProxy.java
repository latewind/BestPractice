package com.latewind.pattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    Object originObj;
    Object proxyObj;

    public static void main(String[] args) {
        Pursure pursure = (Pursure) new DynamicProxy().bind(new RealPursure("Tom"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pursure.giveFlower();
    }

    Object bind(Object originObj) {
        this.originObj = originObj;
        proxyObj = Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(), this);
        return proxyObj;
    }

    @Override
    public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke proxy");
        return method.invoke(originObj, args);
    }
}
