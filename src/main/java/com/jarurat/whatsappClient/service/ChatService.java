package com.jarurat.whatsappClient.service;

import com.jarurat.whatsappClient.model.ChatMessage;

import java.util.List;

public interface ChatService {

    ChatMessage processIncomingMessage(ChatMessage message);

    ChatMessage sendMessage(ChatMessage message);

    ChatMessage saveMessage(ChatMessage message);

    List<ChatMessage> getMessages(String senderId);


}
