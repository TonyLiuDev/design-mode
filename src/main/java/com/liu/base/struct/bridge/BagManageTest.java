package com.liu.base.struct.bridge;

import com.liu.base.utils.Factory;

/**
 * 实现化角色--Color；抽象化角色--Bag；属性关联--组合的方式
 * 将Bag的款式和颜色分离，解耦
 *
 * 桥接模式，虽然采用组合的方式，但是重点是属性的可拓展性
 */
public class BagManageTest {
    public static void main(String[] args) {
        Color color;
        Bag bag;
        try {
            color = Factory.getBean("com.liu.base.struct.bridge.Red");
            bag = Factory.getBean("com.liu.base.struct.bridge.HandBag");
            bag.setColor(color);
            bag.getName();
        } catch (Exception e) {
        }
    }
}
// 实现化角色--颜色
interface Color {
    String getColor();
}
// 具体颜色
class Red implements Color {
    public String getColor() {
        return "red";
    }
}
class Yellow implements Color {
    public String getColor() {
        return "yellow";
    }
}
// 抽象化角色--包
abstract class Bag{
    protected Color color;
    public void setColor(Color color){
        this.color = color;
    }
    public abstract String getName();
}
// 抽象化拓展角色
class HandBag extends Bag{
    public String getName() {
        return color.getColor()+"HandBag";
    }
}
class Wallet extends Bag{
    public String getName() {
        return color.getColor()+"Wallet";
    }
}