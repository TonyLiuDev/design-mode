package com.liu.base.struct.adapter;

/**
 * 双向适配器模式
 */
public class TwoWayTargetTest {
    public static void main(String[] args) {
        TwoWayAdaptee adaptee=new AdapteeRealize(); // 适配者
        TwoWayTarget target=new TwoWayAdapter(adaptee); // 双向适配类
        target.request(); // 顺向适配
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest(); // 逆向适配
    }
}

//目标接口
interface TwoWayTarget {
    public void request();
}
//适配者接口
interface TwoWayAdaptee {
    public void specificRequest();
}
//目标实现
class TargetRealize implements TwoWayTarget {
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
//适配者实现
class AdapteeRealize implements TwoWayAdaptee {
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}
//双向适配器
class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void request() {
        adaptee.specificRequest();
    }
    public void specificRequest() {
        target.request();
    }
}