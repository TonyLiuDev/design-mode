package com.liu.base.create.single;

/**
 * 双重锁校验式
 */
public class DoubleLock {
    // 静态属性--需要被静态方法访问
    // volatile：
    //      此时synchronized保证了instance的可见性,instance是单线程有序性
    //      volatile用于保证DoubleLock的有序性：（3先于2可能返回instanc=null）
    //          1,对象分配内存
    //          2,对象初始化
    //          3,地址赋值给instance
    private static volatile DoubleLock instance;
    private DoubleLock() { }

    public static DoubleLock getInstance() {
        if (instance == null) {
            synchronized (DoubleLock.class) {
                if (instance == null) {
                    instance = new DoubleLock();
                }
            }
        }
        return instance;
    }
}
