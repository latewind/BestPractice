package com.latewind.pattern;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<String> l;
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Hello World!");


    }

    public static Integer func(Integer n) {
        if (n <= 2) {
            return 1;
        }
        Integer tem = func(n - 1) + func(n - 2);

        return tem;
    }

    public static void bol(Integer m) {

        for (Integer i = 1; i < m; i++) {

            System.out.println(func(i));
        }

    }

    public static void newBol(Integer n, HashMap<Integer, BigInteger> map) {
        BigInteger tem = new BigInteger("1");
        for (Integer i = 1; i < n; i++) {
            if (i <= 2) {
                map.put(i, tem);
            } else {
                tem = tem.add(map.get(i - 2));
                map.put(i, tem);
            }
        }
    }

}
