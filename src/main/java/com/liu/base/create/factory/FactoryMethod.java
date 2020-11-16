package com.liu.base.create.factory;

/**
 * 工厂方法模式
 */
public class FactoryMethod {
    public static void main(String[] args) {
        try {
            Product a;
            Factory af;
            af = com.liu.base.utils.Factory.getBean("工厂的实例类的类名");
            a = af.newProduct();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

// 产品的抽象
interface Product {
    public void show();
}
// 具体产品1
class ConcreteProduct1 implements Product {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
// 具体产品2
class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}

// 抽象的工厂：提供了产品的生成方法
interface Factory {
    public Product newProduct();
}
//具体工厂1：实现了产品的生成方法
class ConcreteFactory1 implements Factory {
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
//具体工厂2：实现了产品的生成方法
class ConcreteFactory2 implements Factory {
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
