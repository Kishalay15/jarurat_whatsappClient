package com.jarurat.whatsappClient.controller;

import com.jarurat.whatsappClient.model.ChatMessage;
import com.jarurat.whatsappClient.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/webhook")
    public ResponseEntity<ChatMessage> recieveMessage(@RequestBody ChatMessage message) {
        ChatMessage recieveMessage =  chatService.processIncomingMessage(message);

        return new ResponseEntity<>(recieveMessage, HttpStatus.OK);
    }

    @PostMapping("/send")
    public ResponseEntity<ChatMessage> sendMessage(@RequestBody ChatMessage message) {
        ChatMessage sentMessage = chatService.sendMessage(message);

        return new ResponseEntity<>(sentMessage, HttpStatus.OK);
    }

    @GetMapping("/messages/{senderId}")
    public ResponseEntity<List<ChatMessage>> getMessages(@PathVariable String senderId) {
        List<ChatMessage> messages = chatService.getMessages(senderId);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
