package com.liu.base.action.responsibility;

/**
 * 责任链模式：
 * 学生请假小于或等于 2 天，班主任可以批准；
 * 小于或等于 7 天，系主任可以批准；其他情况不予批准
 */
public class ChainOfResponsibilityPatternTest {
    public static void main(String[] args) {
        // 组装责任链
        Leader leader1 = new ClassAdviser();
        Leader leader2 = new DepartmentHead();
        leader1.setNext(leader2);
        // 处理请求
        leader1.handleRequest(7);
    }
}
// 抽象处理器（审批角色）
abstract class Leader {
    private Leader next;
    // 处理器引用
    public void setNext(Leader next) { this.next = next;}

    public Leader getNext() { return next; }

    // 处理方法
    public abstract void handleRequest(int days);
}
// 处理器实现（班主任）
class ClassAdviser extends Leader {
    public void handleRequest(int days) {
        if (days < 2) {
            System.out.println("班主任批准您请假" + days + "天。");
            return;
        }
        if (getNext() != null) {
            getNext().handleRequest(days);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}
// 处理器实现（系主任）
class DepartmentHead extends Leader {
    public void handleRequest(int days) {
        if (days < 7) {
            System.out.println("系主任批准您请假" + days + "天。");
            return;
        }
        if (getNext() != null) {
            getNext().handleRequest(days);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}
