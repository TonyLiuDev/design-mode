package com.liu.base.struct.adapter;

/**
 * 对象适配器模式
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}

// 对象适配器类
class ObjectAdapter implements Target{
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void request() {
        this.adaptee.specificRequest();
    }
}

