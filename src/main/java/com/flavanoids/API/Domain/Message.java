package com.flavanoids.API.Domain;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 10L;

    private int user_id;

    private int message_id;

    private int conversation_id;

    private String message_content;

    public int getUser_id() {
        return user_id;
    }

    public int getMessage_id() { return message_id; }

    public int getConversation_id() {
        return conversation_id;
    }

    public String getMessage_content() {
        return message_content;
    }
}
