package com.latewind.pattern.creational.factory.abc;

import com.latewind.pattern.structural.decorator.House;
import com.latewind.pattern.structural.facade.Astock;
import com.latewind.pattern.structural.facade.Hstock;
import com.latewind.pattern.structural.facade.Stock;

public class StockFactory extends AbstractFactory {

    @Override
    public House getHouse(String house) {
        return null;
    }

    @Override
    public Stock getStock(String stock) {
        //  Auto-generated method stub
        switch (stock) {
            case "Astock":
                return new Astock();
            case "Hstock":
                return new Hstock();
            default:
                break;
        }
        //  Auto-generated method stub
        return null;
    }

}
