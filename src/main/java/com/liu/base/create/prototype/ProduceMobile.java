package com.liu.base.create.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 生产手机，分为苹果和安卓
 */
public class ProduceMobile {
    public static void main(String[] args) {
        MobileProduceTeam.setMobile("iphone", new Iphone());
        MobileProduceTeam.setMobile("android", new Android());
        Mobile mobile = MobileProduceTeam.getMobile("");
    }
}

// 手机
interface Mobile extends Cloneable {
    Object clone();
    void call(); // 功能
}
// 苹果手机
class Iphone implements Mobile {
    public Object clone() {
        Iphone iphone = null;
        try {
            iphone = (Iphone) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return iphone;
    }
    public void call() {
        System.out.println("iphone call");
    }
}
// 安卓手机
class Android implements Mobile {
    public Object clone() {
        Android android = null;
        try {
            android = (Android) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return android;
    }
    public void call() {
        System.out.println("android call");
    }
}

// 原型管理器：手机生产小组
class MobileProduceTeam {
    private static Map<String, Mobile> map = new HashMap(); // 存储原型机
    public static void setMobile(String key, Mobile mobile) {
        map.put(key, mobile);
    }
    public static Mobile getMobile(String key) {
        Mobile mobile = map.get(key);
        if (mobile != null) {
            return (Mobile) mobile.clone();
        }
        return null;
    }
}
