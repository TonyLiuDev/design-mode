package com.liu.base.action.strategy;

import com.liu.base.utils.Factory;

/**
 * 策略模式 -- 大闸蟹的做法
 */
public class StrategyPatternTest {
    public static void main(String[] args) throws Exception {
        // 获取具体策略
        CrabCooking strategy = Factory.getBean("com.liu.base.struct.strategy.SteamedCrabs");
        // 设置策略，并环境类调用
        Kitchen envir = new Kitchen();
        envir.setCooking(strategy);
        int result = envir.cookingMethod();
    }
}
// 抽象策略类：大闸蟹加工类
interface CrabCooking {
    public int cookingMethod();    // 做菜的方法
}
// 具体策略类：清蒸大闸蟹
class SteamedCrabs implements CrabCooking{
    public int cookingMethod() {
        return 1;
    }
}
// 具体策略类：红烧大闸蟹
class BraisedCrabs implements CrabCooking{
    public int cookingMethod() {
        return 2;
    }
}
//环境类：厨房
class Kitchen{
    private CrabCooking cooking; // 策略
    public CrabCooking getCooking() {
        return cooking;
    }
    public void setCooking(CrabCooking cooking) {
        this.cooking = cooking;
    }
    // 客户使用方法
    public int cookingMethod(){
        return cooking.cookingMethod();
    }
}
