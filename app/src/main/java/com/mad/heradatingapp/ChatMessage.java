package com.mad.heradatingapp;

public class ChatMessage {
    private String messageText;
    private String messageUser;
    private long messsagTime;

    public ChatMessage(String messageText, String messageUser, long messsagTime) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messsagTime = messsagTime;
    }
}
