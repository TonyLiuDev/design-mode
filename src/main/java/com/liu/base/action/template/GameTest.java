package com.liu.base.action.template;

/**
 * Game模板抽象类
 * 具体实现类足球、篮球
 */
public class GameTest {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();
    }
}

// 抽象类game
abstract class Game {
    // 基本方法 -- 抽象方法
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    // 模板方法
    public final void play() {
        initialize();//初始化游戏
        startPlay();//开始游戏
        endPlay();//结束游戏
        end();
    }
    // 基本方法 -- 具体方法
    public void end() {
        System.out.println("game end");
    }
}

// 足球
class Football extends Game {
    void initialize() {
        System.out.println("Football initialize");
    }
    void startPlay() {
        System.out.println("Football startPlay");
    }
    void endPlay() {
        System.out.println("Football endPlay");
    }
}

// 篮球
class Basketball extends Game {
    void initialize() {
        System.out.println("Basketball initialize");
    }
    void startPlay() {
        System.out.println("Basketball startPlay");
    }
    void endPlay() {
        System.out.println("Basketball endPlay");
    }
}
