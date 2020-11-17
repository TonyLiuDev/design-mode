package com.liu.base.action.command;

import java.util.LinkedList;
import java.util.List;

/**
 * 宏命令
 */
public class CompositeCommandTest {
    public static void main(String[] args) {
        // 执行者
        Receiver receiver = new Receiver();
        // 宏命令
        CompositeCommand command = new CompositeCommand();
        command.add(new CommandA(receiver));
        command.add(new CommandB(receiver));
        // 执行宏命令
        command.execute();
    }
}
// 执行方
class Receiver {
    public void actionA() {
        System.out.println("actionA 被调用");
    }
    public void actionB() {
        System.out.println("actionB 被调用");
    }
}
// 抽象命令
interface AbsCommand {
    void execute();
}
// 命令A
class CommandA implements AbsCommand {
    private Receiver receiver;
    public CommandA(Receiver receiver) {
        this.receiver = receiver;
    }
    public void execute() {
        receiver.actionA();
    }
}
// 命令B
class CommandB implements AbsCommand {
    private Receiver receiver;
    public CommandB(Receiver receiver) {
        this.receiver = receiver;
    }
    public void execute() {
        receiver.actionB();
    }
}
// 命令组合者
class CompositeCommand implements AbsCommand {
    private List<AbsCommand> children = new LinkedList();
    public void add(AbsCommand c) {
        children.add(c);
    }
    // 对外入口
    public void execute() {
        for (AbsCommand child : children) {
            child.execute();
        }
    }
}