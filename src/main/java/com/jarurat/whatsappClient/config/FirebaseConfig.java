package com.jarurat.whatsappClient.config;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() {
        try{
            String firebaseConfig = System.getenv("FIREBASE_CONFIG");

//            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("target-whatsapp-firebase-adminsdk-fbsvc-98c8290ca7.json");

            InputStream serviceAccount = new ByteArrayInputStream(firebaseConfig.getBytes(StandardCharsets.UTF_8));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase initialized successfully");
            }
        } catch (Exception e) {
            System.err.println("Failed to initialize Firebase");
            e.printStackTrace();
        }
    }
}
