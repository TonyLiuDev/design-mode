package com.liu.base.action.command;

/**
 * 命令模式--点餐
 */
public class CookingTest {
    public static void main(String[] args) {
        // 调用方生成命令
        Breakfast baoZi = new BaoZi();
        // 执行方添加命令
        Waiter waiter = new Waiter();
        waiter.setBaoZi(baoZi);
        // 执行命令
        waiter.chooseBaoZi();
    }
}
// 命令抽象（早餐）
interface Breakfast {
    void cook(); // 制作
}
// 命令实现（包子）
class BaoZi implements Breakfast {
    public void cook() {
        System.out.println("包子");
    }
}
// 命令实现（饺子）
class JiaoZi implements Breakfast {
    public void cook() {
        System.out.println("饺子");
    }
}
// 服务员
class Waiter {
    private Breakfast baoZi, jiaoZi;
    public void setJiaoZi(Breakfast jiaoZi) {
        this.jiaoZi = jiaoZi;
    }
    public void setBaoZi(Breakfast baoZi) {
        this.baoZi = baoZi;
    }
    public void chooseBaoZi() {
        baoZi.cook();
    }
    public void chooseJiaoZi() {
        jiaoZi.cook();
    }
}
