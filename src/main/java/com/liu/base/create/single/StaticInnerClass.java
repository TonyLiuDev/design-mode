package com.liu.base.create.single;

/**
 * 静态内部类式
 * instance：
 *      虽然式内部类私有，但是编译后会在内部类生成static的access方法，
 *      所以外部类可以访问内部类的私有属性、方法（编译器干的）
 */
public class StaticInnerClass {
    private StaticInnerClass() { }

    // 私有静态内部类
    private static class SingleHolder {
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    // 调用静态方法时，才初始化内部类
    public static final StaticInnerClass getInstance() {
        return SingleHolder.instance;
    }
}
