package com.liu.base.action.observer;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/**
 * 观察者模式：学校的钟与学生
 */
public class BellEventTest {
    public static void main(String[] args) {
        // 目标对象--钟
        BellEventSource bell = new BellEventSource();
        // 注册观察者--学生
        bell.addPersonListener(new StuEventListener());
        bell.ring(true);   // 上课铃声
        bell.ring(false);  //下课铃声
    }
}

// 事件类：（观察者与目标之间的消息对象）
class RingEvent extends EventObject {
    private boolean sound;
    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }
    public boolean getSound() {
        return sound;
    }
    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
// 抽象观察者类
interface BellEventListener extends EventListener {
    // 收到消息并变化（执行方法）
    public void heardBell(RingEvent e);
}
// 观察者实现类(学生)
class StuEventListener implements BellEventListener {
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}
// 目标类（钟）
class BellEventSource {
    private List<BellEventListener> listeners = new ArrayList();
    // 添加观察类（给事件源绑定监听器 ）
    public void addPersonListener(BellEventListener ren) {
        listeners.add(ren);
    }
    // 目标变化(敲钟)
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响！");
        // 发布铃声事件并通知
        RingEvent event = new RingEvent(this, sound);
        notifies(event);
    }
    // 事件触发器后，通知观察类
    protected void notifies(RingEvent e) {
        BellEventListener ren = null;
        for (BellEventListener listener : listeners) {
            listener.heardBell(e);
        }
    }
}




