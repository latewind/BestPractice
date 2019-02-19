package com.latewind.pattern.creational.prototype;


public class Resume implements Cloneable {

    private String name;

    private Integer age;


    @Override
    public Object clone() throws CloneNotSupportedException {
        //  Auto-generated method stub
        return super.clone();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


}
