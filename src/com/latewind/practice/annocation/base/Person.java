package com.latewind.practice.annocation.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface Person {
	String name() default "";
}