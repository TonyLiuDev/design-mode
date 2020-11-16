package com.liu.base.create.builder;

import com.liu.base.utils.Factory;

/**
 * 建造者模式
 */
public class ParlourDecorator {
    public static void main(String[] args) {
        // 产品为客厅装修（包含墙体、电视、沙发），
        // 建造者是装修队、指挥者是项目经理
        try {
            // 配置获取具体的装修队，ConcreteDecoratorA可以生产具体零件(如：WallA)
            Decorator decorator = Factory.getBean("com.liu.base.create.builder.ConcreteDecoratorA");
            // 项目经理调用、组装、返回
            ProjectManager projectManager = new ProjectManager(decorator);
            Parlour parlour = projectManager.decorate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// 客厅（墙体、电视、沙发都有多种款式）
class Parlour{
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发

    public void setWall(String wall) {
        this.wall = wall;
    }
    public void setTV(String TV) {
        this.TV = TV;
    }
    public void setSofa(String sofa) {
        this.sofa = sofa;
    }
}
// 建造者抽象
abstract class Decorator{
    protected  Parlour parlour = new Parlour();
    public Parlour getParlour() {
        return parlour;
    }
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();
}
// 建造者实现-装修队A
class ConcreteDecoratorA extends Decorator{
    public void buildWall() {
        parlour.setWall("WallA");
    }
    public void buildTV() {
        parlour.setTV("TVA");
    }
    public void buildSofa() {
        parlour.setSofa("SofaA");
    }
}
// 项目经理--调用建造者并组装
class ProjectManager{
    private Decorator decorator;
    public ProjectManager(Decorator decorator){
        this.decorator=decorator;
    }
    public Parlour decorate(){
        decorator.buildWall();
        decorator.buildTV();
        decorator.buildSofa();
        return decorator.getParlour();
    }
}

