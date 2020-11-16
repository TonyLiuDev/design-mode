package com.liu.base.action.state;

public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext(); // 新建线程  New
        context.start(); // 线程从New 到 Runnable
        context.start(); // 线程从Runnable 到 Dead
    }
}

// 环境类
class ThreadContext {
    private ThreadState state;
    ThreadContext() { state = new New();}
    public void setState(ThreadState state) {
        this.state = state;
    }
    public ThreadState getState() {
        return state;
    }
    // 执行并进入下一状态
    public void start() {
        state.start(this);
    }
}

// 抽象状态类：线程状态
abstract class ThreadState {
    protected String stateName; //状态名
    public abstract void start(ThreadContext context); // 线程的状态转换
}

// 具体状态类：新建状态
class New extends ThreadState {
    public New() {
        stateName = "新建状态";
        System.out.println("当前线程处于：新建状态.");
    }
    public void start(ThreadContext hj) {
        System.out.print("调用start()方法-->");
        if (stateName.equals("新建状态")) {
            hj.setState(new Runnable()); // 下一状态
        } else {
            System.out.println("当前线程不是新建状态，不能调用start()方法.");
        }
    }
}

//具体状态类：就绪状态
class Runnable extends ThreadState {
    public Runnable() {
        stateName = "就绪状态";
        System.out.println("当前线程处于：就绪状态.");
    }
    public void start(ThreadContext hj) {
        System.out.print("获得CPU时间-->");
        if (stateName.equals("就绪状态")) {
            hj.setState(new Dead());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}

//具体状态类：死亡状态
class Dead extends ThreadState {
    public Dead() {
        stateName = "死亡状态";
        System.out.println("当前线程处于：死亡状态.");
    }
    public void start(ThreadContext context) {
        System.out.println("结束");
    }
}


