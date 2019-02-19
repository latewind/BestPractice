package com.latewind.test.pattern;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import com.latewind.pattern.behavioral.chain.BaseLogger;
import com.latewind.pattern.behavioral.chain.Logger;
import com.latewind.pattern.behavioral.command.Commend;
import com.latewind.pattern.behavioral.command.Invoker;
import com.latewind.pattern.behavioral.command.Receiver;
import com.latewind.pattern.behavioral.command.RunCommend;
import com.latewind.pattern.behavioral.command.StopCommend;
import com.latewind.pattern.behavioral.mediator.ChatRoom;
import com.latewind.pattern.behavioral.mediator.Mediator;
import com.latewind.pattern.behavioral.mediator.Member;
import com.latewind.pattern.behavioral.mediator.OrdMember;
import com.latewind.pattern.behavioral.memono.CareTaker;
import com.latewind.pattern.behavioral.memono.Role;
import com.latewind.pattern.behavioral.observer.IamReminder;
import com.latewind.pattern.behavioral.observer.MobileObserver;
import com.latewind.pattern.behavioral.observer.Observer;
import com.latewind.pattern.behavioral.observer.Reminder;
import com.latewind.pattern.behavioral.observer.StockObserver;
import com.latewind.pattern.behavioral.state.EveryDay;
import com.latewind.pattern.behavioral.template.FootBallGame;
import com.latewind.pattern.behavioral.template.Game;
import com.latewind.pattern.behavioral.visitor.Chairman;
import com.latewind.pattern.behavioral.visitor.Citizen;
import com.latewind.pattern.behavioral.visitor.Interviewer;
import com.latewind.pattern.behavioral.visitor.Person;
import com.latewind.pattern.behavioral.visitor.Visitor;
import com.latewind.pattern.creational.builder.Computer;
import com.latewind.pattern.creational.builder.Director;
import com.latewind.pattern.creational.builder.LaptopBuilder;
import com.latewind.pattern.creational.factory.Operation;
import com.latewind.pattern.creational.factory.PlusFactoryMethod;
import com.latewind.pattern.creational.factory.PlusOperation;
import com.latewind.pattern.creational.factory.SimpleFactory;
import com.latewind.pattern.creational.factory.StrategyContext;
import com.latewind.pattern.creational.factory.abc.AbstractFactory;
import com.latewind.pattern.creational.factory.abc.FactoryProducer;
import com.latewind.pattern.creational.prototype.Resume;
import com.latewind.pattern.creational.single.Single;
import com.latewind.pattern.structural.adapter.Coach;
import com.latewind.pattern.structural.adapter.ForeignPlayer;
import com.latewind.pattern.structural.adapter.Forward;
import com.latewind.pattern.structural.adapter.Translater;
import com.latewind.pattern.structural.bridge.HuaWei;
import com.latewind.pattern.structural.bridge.IPhone;
import com.latewind.pattern.structural.bridge.Phone;
import com.latewind.pattern.structural.bridge.WeChatApp;
import com.latewind.pattern.structural.bridge.WeiboApp;
import com.latewind.pattern.structural.composite.Employee;
import com.latewind.pattern.structural.decorator.Bungalow;
import com.latewind.pattern.structural.decorator.DoorDecorator;
import com.latewind.pattern.structural.decorator.House;
import com.latewind.pattern.structural.decorator.WindowDecorator;
import com.latewind.pattern.structural.facade.Astock;
import com.latewind.pattern.structural.facade.Facade;
import com.latewind.pattern.structural.facade.Hstock;
import com.latewind.pattern.structural.proxy.ProxyPursure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class DesignPatternTest {


    @Test
    public void testAbstractFactory() {
        System.out.println("==================Abstract Factory Pattern=====================");
        AbstractFactory houseFactory = FactoryProducer.getHouseFactory();
        House bHouse = houseFactory.getHouse("Bungalow");
        bHouse.display();
    }


    @Test
    public void testSimplePattern() {
        System.out.println("============Samile Factory Pattern=============");
        Operation operation = SimpleFactory.getOperation("+").setValue(1, 2);
        System.out.println(operation.gerResult());
    }

    @Test
    public void testFactoryMethod() {
        System.out.println("============Factory Method Pattern=============");
        PlusFactoryMethod plusFactoryMethod = new PlusFactoryMethod();
        Operation addOperation = plusFactoryMethod.getOperation();
        System.out.println(addOperation.setValue(1.0, 2.0).gerResult());
    }

    @Test
    public void testStrategy() {
        System.out.println("================Strategy Pattern=====================");
        StrategyContext sc = new StrategyContext(new PlusOperation());
        System.out.println(sc.executeStrategy(1, 2));

        House house = new Bungalow();
        WindowDecorator wd = new WindowDecorator();
        DoorDecorator dd = new DoorDecorator();
        wd.decorator(house);
        dd.decorator(wd);
        dd.display();
    }

    @Test
    public void testProxyPattern() {
        System.out.println("==================Test Proxy=====================");
        ProxyPursure proxyPursure = new ProxyPursure("美眉");
        proxyPursure.giveFlower();
        proxyPursure.giveMoney();
    }

    @Test
    public void testPrototype() throws CloneNotSupportedException {
        System.out.println("==================Prototype=====================");

        Resume resume = new Resume();
        resume.setAge(26);
        resume.setName("LSQ");
        Resume other = (Resume) resume.clone();
        other.setName("LateWind");

        System.out.println(resume);

        System.out.println(other);
    }

    @Test
    public void testTemplatePattern() {
        System.out.println("==================Template Pattern=====================");
        Game game = new FootBallGame();
        game.runGame();
    }

    @Test
    public void testFacadePattern() {
        System.out.println("==================Facade Pattern=====================");
        Facade facade = new Facade(new Astock(), new Hstock());
        facade.in();
        facade.out();
    }

    @Test
    public void testBuilderPattern() {
        System.out.println("==================Builder Pattern=====================");
        Director director = new Director(new LaptopBuilder());
        director.constructComputer();
        Computer computer = director.getComputer();
        System.out.println(computer.toString());
    }

    @Test
    public void testObserverPattern() {
        System.out.println("==================Observer Pattern=====================");
        Reminder reminder = new IamReminder();

        Observer stockObserver = new StockObserver(reminder);

        Observer mObserver = new MobileObserver(reminder);

        reminder.attach(stockObserver);
        reminder.attach(mObserver);
        reminder.notice();
    }

    @Test
    public void testStatePattern() {
        System.out.println("==================State Pattern=====================");
        EveryDay everyDay = new EveryDay(LocalDateTime.now());
        everyDay.done();
    }

    @Test
    public void testAdapterPattern() {
        System.out.println("==================Adapter Pattern=====================");
        Coach coach = new Coach(new Forward());
        coach.attackAction();
        coach.setPlayer(new Translater(new ForeignPlayer()));
        coach.attackAction();
    }

    @Test
    public void testMementoPattern() {
        System.out.println("==================Memento Pattern=====================");
        Random random = new Random();
        CareTaker careTaker = new CareTaker();
        Role role = new Role();
        role.setVit(random.nextInt());
        careTaker.setMemento(role.saveStatus());
        System.out.println(role);

        role.setVit(random.nextInt());
        careTaker.setMemento(role.saveStatus());
        System.out.println(role);

        role.setVit(random.nextInt());
        careTaker.setMemento(role.saveStatus());
        System.out.println(role);

        role.resumeStatus(careTaker.getMemento(2));
        System.out.println(role);

        role.resumeStatus(careTaker.getMemento(1));
        System.out.println(role);

        role.resumeStatus(careTaker.getMemento(0));
        System.out.println(role);
    }

    @Test
    public void testBridgePattern() {
        System.out.println("==================Bridge Pattern=====================");

        Phone iPhone = new IPhone();
        iPhone.install(new WeChatApp());
        iPhone.runApp();

        iPhone.install(new WeiboApp());
        iPhone.runApp();

        Phone huaWei = new HuaWei();
        huaWei.install(new WeChatApp());
        huaWei.runApp();
    }

    @Test
    public void testMediator() {
        System.out.println("==================Mediator Pattern=====================");
        Mediator chatRoom = new ChatRoom();

        Member zs = new OrdMember(chatRoom, "Tom");

        Member ls = new OrdMember(chatRoom, "Lily");

        Member ww = new OrdMember(chatRoom, "Jones");

        zs.send("hello,everyone");
    }

    @Test
    public void testCommend() {
        System.out.println("==================Commend Pattern=====================");

        Receiver receiver = new Receiver();
        Commend runCommend = new RunCommend(receiver);
        Commend stopCommend = new StopCommend(receiver);

        Invoker invoker = new Invoker();
        invoker.executeCmd(runCommend);

        invoker.executeCmd(stopCommend);
    }

    @Test
    public void testSingelPattern() {
        System.out.println("==================Single Pattern=====================");
        Single single = Single.getInstance();
        single.show();
    }

    @Test
    public void testVisitor() {
        System.out.println("==================Visitor Pattern=====================");
        Person chairman = new Chairman();
        Person citizen = new Citizen();
        Visitor visitor = new Interviewer();
        chairman.accept(visitor);
        citizen.accept(visitor);
    }

    @Test
    public void testComposite() {
        System.out.println("==================Composite Pattern=====================");
        Employee tom = new Employee("Tom", false, new ArrayList<Employee>(0));
        Employee david = new Employee("David", false, new ArrayList<Employee>(0));
        Employee jim = new Employee("Jim", false, new ArrayList<Employee>(0));
        List<Employee> subEmployees = new ArrayList<>(3);
        Collections.addAll(subEmployees, tom, david, jim);
        Employee king = new Employee("King", true, subEmployees);
        System.out.println(king.toString());
    }


    @Test
    public void testChainPattern() {
        BaseLogger logger = Logger.getLogger();
        logger.log(BaseLogger.ERROR, "Error log");
        logger.log(BaseLogger.DEBUG, "Debug log");
        logger.log(BaseLogger.INFO, "Info log");
    }

}
