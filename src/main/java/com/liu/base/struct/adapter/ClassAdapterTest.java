package com.liu.base.struct.adapter;

/**
 * 类适配器模式
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}

// 目标接口
interface Target{
    void request();
}
// 适配者类
class Adaptee{
    public void specificRequest(){
        System.out.println("原有业务逻辑");
    }
}
// 类适配器类
class ClassAdapter extends Adaptee implements Target{
    public void request() {
        this.specificRequest();
    }
}
