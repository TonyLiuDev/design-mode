package com.liu.base.action.mediator;

/**
 * 中介者模式
 */
public class ChatRoomTest {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        User userA = new User("A", room);
        User userB = new User("B", room);
        userA.sendMessage("开始");
        userB.sendMessage("结束");
    }
}
// 中介者--聊天室
class ChatRoom {
    public void showMessage(User user, String message) {
        System.out.println(user.getName() + "说： " + message);
    }
}
// 同事类--用户
class User {
    private String name;
    private ChatRoom room;
    public User(String name, ChatRoom room) {
        this.name = name;
        this.room = room;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ChatRoom getRoom() { return room; }
    public void setRoom(ChatRoom room) { this.room = room; }
    public void sendMessage(String name) { room.showMessage(this, name); }
}
