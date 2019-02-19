package com.latewind.pattern.creational.factory.abc;

public class FactoryProducer {

    public static AbstractFactory getStockFactory() {

        return new StockFactory();
    }

    public static AbstractFactory getHouseFactory() {

        return new HouseFactory();
    }

}
