package com.liu.base.struct.composite;

import java.util.ArrayList;

/**
 * 一个大袋子装了1 双李宁牌运动鞋（单价 198 元）、中袋子。
 * 中袋子有1 个景德镇瓷器（单价 380 元）、红色小袋子。
 * 红色小袋子里面有2 包婺源特产（单价 7.9 元）、1 张婺源地图（单价 9.9 元），
 * 要求显示商品信息，以及总价
 */
public class ShoppingTest {
    public static void main(String[] args) {
        float s=0;
        Bags bigBag,mediumBag,smallRedBag;
        Goods goods;
        bigBag = new Bags("大袋子");
        mediumBag = new Bags("中袋子");
        smallRedBag = new Bags("红色小袋子");
        goods = new Goods("婺源特产", 2, 7.9f);
        smallRedBag.add(goods);
        goods = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(goods);
        goods = new Goods("景德镇瓷器", 1, 380f);
        mediumBag.add(goods);
        mediumBag.add(smallRedBag);
        goods = new Goods("双李宁牌运动鞋", 1, 198f);
        bigBag.add(goods);
        bigBag.add(mediumBag);
        bigBag.calculation();
        bigBag.show();
    }
}
// 抽象构件：物品(商品、袋子都展示价格和信息)
interface Articles{
    float calculation();
    void show();
}
// 商品
class Goods implements Articles{
    private String name;     //名字
    private int quantity;    //数量
    private float unitPrice; //单价
    public Goods(String name,int quantity,float unitPrice) {
        this.name=name;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }
    public float calculation() {
        return quantity*unitPrice;
    }
    public void show() {
        System.out.println(name+"(数量："+quantity+"，单价："+unitPrice+"元)");
    }
}
// 树枝构件：袋子
class Bags implements Articles{
    private String name;     //名字
    private ArrayList<Articles> bags=new ArrayList<Articles>();
    public Bags(String name) {
        this.name=name;
    }
    public void add(Articles c) {
        bags.add(c);
    }
    public void remove(Articles c) {
        bags.remove(c);
    }
    public Articles getChild(int i) {
        return bags.get(i);
    }
    public float calculation() {
        float s=0;
        for(Object obj:bags) {
            s+=((Articles)obj).calculation();
        }
        return s;
    }
    public void show() {
        for(Object obj:bags) {
            ((Articles)obj).show();
        }
    }
}
