package com.liu.base.create.single;

/**
 * 懒汉式
 */
public class Lazy {
    // 静态属性
    private static Lazy instance;
    private Lazy() { }

    // 线程安全访问静态方法
    public static synchronized Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
