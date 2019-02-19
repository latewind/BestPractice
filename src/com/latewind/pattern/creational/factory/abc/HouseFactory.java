package com.latewind.pattern.creational.factory.abc;

import com.latewind.pattern.structural.decorator.Bungalow;
import com.latewind.pattern.structural.decorator.House;
import com.latewind.pattern.structural.facade.Stock;

public class HouseFactory extends AbstractFactory {

    @Override
    public House getHouse(String house) {

        switch (house) {
            case "Bungalow":
                return new Bungalow();
            default:
                break;
        }
        //  Auto-generated method stub


        return null;
    }

    @Override
    public Stock getStock(String stock) {
        //  Auto-generated method stub
        return null;
    }

}
