package com.latewind.pattern.structural.proxy.dynamic;

public class BusinessService {

    public UserDao userDao;

    public void getUser() {
        userDao.getUser();
    }

}
