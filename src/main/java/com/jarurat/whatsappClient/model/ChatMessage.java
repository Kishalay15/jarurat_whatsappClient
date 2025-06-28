package com.jarurat.whatsappClient.model;

import lombok.Data;

@Data
public class ChatMessage {

    private String id;
    private String senderId;
    private String message;
    private long timestamp;
}
