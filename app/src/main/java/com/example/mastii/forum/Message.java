package com.example.mastii.forum;

import java.util.Date;

public class Message {
    public String userName;
    public String userRole;
    public String textMessage;
    private long messageTime;

    public void Message() {
    }

    public void Message(String userName, String userRole, String textMessage) {
        this.userName = userName;
        this.userRole = userRole;
        this.textMessage = textMessage;

        this.messageTime = new Date().getTime();
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
