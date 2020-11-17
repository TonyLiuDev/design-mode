package com.liu.base.struct.facade;

/**
 * 外观模式
 */
public class FacadePatternTest {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
    }
}
// 形状
interface Shape{
    void draw();
}
// 子系统 -- 圆形
class Circle implements Shape{
    public void draw() {
        System.out.println("this is Circle");
    }
}
// 子系统 -- 方形
class Square implements Shape{
    public void draw() {
        System.out.println("this is Square");
    }
}
// 外观类
class ShapeMaker {
    private Shape circle;
    private Shape square;
    public ShapeMaker(){
        circle = new Circle();
        square = new Square();
    }
    // 对外提供子系统的访问入口
    public void drawCircle(){
        circle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}