package com.latewind.pattern.creational.factory.abc;

import com.latewind.pattern.structural.decorator.House;
import com.latewind.pattern.structural.facade.Stock;

public abstract class AbstractFactory {

    public abstract House getHouse(String house);

    public abstract Stock getStock(String stock);

}
