package com.liu.base.utils;

public class Factory {
    // 通过类名获取工厂实例，可以使用读取配置等方式，获取具体工厂类的类名
    public static <T> T getBean(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        T af = (T)clazz.newInstance();
        return af;
    }
}
