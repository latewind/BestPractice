package com.latewind.practice.steam;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

public class ArraySteam {

    public static void main(String[] args) {
        String[] persons = {"A", "B", "C", "D"};
        System.out.println(persons);
        Stream<String> subs = Arrays.stream(persons,1,3);
        System.out.println(persons);


    }
}
