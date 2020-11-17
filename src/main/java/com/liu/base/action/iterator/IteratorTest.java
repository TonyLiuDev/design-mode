package com.liu.base.action.iterator;

/**
 * 迭代器模式
 */
public class IteratorTest {
    public static void main(String[] args) {
        NameList list = new NameList();
        Iterator iterator = list.getIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}
// 迭代器抽象 (类似于java迭代器)
interface Iterator {
    public boolean hasNext();
    public Object next();
}
// 聚合类抽象（类似于List）
interface Container {
    public Iterator getIterator();
}
// 聚合类实现 （类似于ArrayList）
class NameList implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};
    public Iterator getIterator() {
        return new NameIterator(this);
    }
}
// 迭代器实现 （类似于ArrayList迭代器实现）
class NameIterator implements Iterator {
    private int index;
    private NameList list;
    public NameIterator(NameList list) {
        this.list = list;
    }
    public boolean hasNext() {
        if (index < list.names.length - 1) {
            return true;
        }
        return false;
    }
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.names[index];
        }
        return obj;
    }
}
