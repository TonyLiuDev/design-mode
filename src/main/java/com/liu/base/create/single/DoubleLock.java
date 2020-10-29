package com.liu.base.create.single;

/**
 * 双重锁校验式
 */
public class DoubleLock {
    // 静态属性--需要被静态方法访问
    // volatile：
    //      instance在加锁实例化后，因为volatile会
    //      及时刷新到主内存中，防止未及时刷新到主内存导致其他线程阻塞
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
