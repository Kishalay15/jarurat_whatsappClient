package com.jarurat.whatsappClient.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.jarurat.whatsappClient.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ChatServiceImplementation implements ChatService {

    private static final String COLLECTION_NAME = "chat_messages";

    @Override
    public ChatMessage processIncomingMessage(ChatMessage message) {
        message.setTimestamp(System.currentTimeMillis());
        return saveMessage(message);
//        System.out.println("Incoming message saved: " + message.getMessage());
    }

    @Override
    public ChatMessage sendMessage(ChatMessage message) {
        message.setTimestamp(System.currentTimeMillis());
        return saveMessage(message);
//        System.out.println("Outgoing message saved: " + message.getMessage());
    }

    @Override
    public ChatMessage saveMessage(ChatMessage message) {
        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection(COLLECTION_NAME).add(message);
        return message;
    }

    @Override
    public List<ChatMessage> getMessages(String senderId) {
        List<ChatMessage> messages = new ArrayList<>();
        Firestore firestore = FirestoreClient.getFirestore();

        try {
            ApiFuture<QuerySnapshot> future = firestore.collection(COLLECTION_NAME).whereEqualTo("senderId", senderId).get();

            List<QueryDocumentSnapshot> docs = future.get().getDocuments();

            for (DocumentSnapshot doc : docs) {
                messages.add(doc.toObject(ChatMessage.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
