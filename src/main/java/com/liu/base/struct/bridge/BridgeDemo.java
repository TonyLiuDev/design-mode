package com.liu.base.struct.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        Implementor a = new ConcreteImplementorA(); // 实现化角色
        Abstraction abstraction = new ConcreteAbstraction(a); // 抽象化角色
        abstraction.operation(); // 抽象化角色 调用 实现化角色方法
    }
}
//实现化角色
interface Implementor{
    void operationImpl();
}
// 具体实现化角色A
class ConcreteImplementorA implements Implementor {
    public void operationImpl() {
        System.out.println("具体实现化ConcreteImplementorA角色被访问");
    }
}
// 抽象化角色 ：（聚合关系放抽象层）
abstract class Abstraction {
    protected Implementor imple; // 实现化角色
    protected Abstraction(Implementor imple) {
        this.imple = imple;
    }
    public abstract void operation();
}
// 拓展抽象化角色
class ConcreteAbstraction extends Abstraction {
    protected ConcreteAbstraction(Implementor imple) {
        super(imple);
    }
    public void operation() {
        imple.operationImpl();
    }
}
