package com.liu.base.create.single;

/**
 * 饿汉式
 */
public class Hungry {
    // 静态属性，类加载便初始化
    private static Hungry instance = new Hungry();
    private Hungry() {}

    // 静态方法，获取对象
    public static Hungry getInstance() {
        return instance;
    }
}
