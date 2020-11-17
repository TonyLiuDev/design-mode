package com.liu.base.create.factory;


import com.liu.base.utils.Factory;

public class AbstractFactory {
    public static void main(String[] args) {
        Farm f;
        try {
            // 获取农场(A或者B)
            f = Factory.getBean("com.liu.base.create.FarmA");
            // 根据农场，获取对应的动物、植物
            Animal animal = f.newAnimal();
            Plant plant = f.newPlant();
            animal.show();
            plant.show();
        }catch (Exception e){
        }
    }

}

// 抽象产品--动物
interface Animal {
    public void show();
}
// 抽象产品--植物
interface Plant {
    public void show();
}
//抽象工厂：农场类
interface Farm {
    public Animal newAnimal();
    public Plant newPlant();
}

//  产品的实现
// 动物的实现--马
class Horse implements Animal{
    public void show() {
        System.out.println("这是马");
    }
}
// 动物的实现--牛
class Cattle implements Animal{
    public void show() {
        System.out.println("这是牛");
    }
}
// 植物的实现--水果
class Fruit implements Plant{
    public void show() {
        System.out.println("这是水果");
    }
}
// 植物的实现--蔬菜
class Vegetables implements Plant{
    public void show() {
        System.out.println("这是蔬菜");
    }
}

// 抽象工厂的实现
// 农场A
class FarmA implements Farm {
    public Animal newAnimal() {
        System.out.println("新牛出生！");
        return new Cattle();
    }
    public Plant newPlant() {
        System.out.println("蔬菜长成！");
        return new Vegetables();
    }
}
// 农场B
class FarmB implements Farm {
    public Animal newAnimal() {
        System.out.println("新马出生！");
        return new Horse();
    }
    public Plant newPlant() {
        System.out.println("水果长成！");
        return new Fruit();
    }
}
