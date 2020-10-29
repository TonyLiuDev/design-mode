package com.liu.base.create.factory;

/**
 * @description:
 * @author: lb
 * @create: 2020/10/26
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product p = SimpleFactory.getInstance(Const.A);
        p.show();
    }

    // 工厂的static方法
    public static Product getInstance(Const type) {
        Product p;
        if (Const.A.equals(type)) {
            p = new CreateProductA();
        } else if (Const.B.equals(type)) {
            p = new CreateProductB();
        } else {
            p = null;
        }
        return p;
    }

    // 抽象的产品
    public interface Product {
        void show();
    }

    // 产品的实现--产品A
    static class CreateProductA implements Product {
        public void show() {
            System.out.println("this is CreateProductA");
        }
    }

    // 产品的实现--产品B
    static class CreateProductB implements Product {
        public void show() {
            System.out.println("this is CreateProductB");
        }
    }

    // 枚举
    enum Const {
        A, B;
    }
}
