
# 📱 WhatsApp Chatbot Backend – Java + Spring Boot

This is a backend service built using **Java**, **Spring Boot**, and **Firebase**, designed to simulate a WhatsApp chatbot workflow for the Jarurat Care internship assignment.

## 🚀 Features

- Accepts incoming messages via `/webhook` endpoint
- Simulates sending messages via `/send` endpoint
- Stores all messages in **Cloud Firestore (Firebase)**
- Retrieves chat history by user
- Mock integration with **Meta WhatsApp Business API**
- Deployable on **Render**

---

## 🧑‍💻 Tech Stack

- Java 17
- Spring Boot 3
- Firebase Admin SDK
- Firestore (NoSQL DB)
- REST APIs
- Maven
- Render (for deployment)

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.jarurat.whatsappClient/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── model/
│   │       └── config/
│   └── resources/
│       └── application.properties
```

---

## 📦 API Endpoints

| Method | Endpoint                    | Description                         |
|--------|-----------------------------|-------------------------------------|
| POST   | `/api/chat/webhook`         | Simulates incoming WhatsApp message |
| POST   | `/api/chat/send`            | Simulates sending a message         |
| GET    | `/api/chat/messages/{id}`   | Fetch messages by senderId          |

### 📥 Sample POST Body

```json
{
  "senderId": "user123",
  "message": "Hello!"
}
```

---

## 🔐 Firebase Integration

- Uses Firebase Admin SDK to connect to Firestore.
- Credentials are **not hardcoded** or committed.
- Firebase key is loaded via environment variable `FIREBASE_CONFIG`.

---

## 🛠 Running Locally

### Prerequisites
- Java 17+
- Maven
- Firebase Project with Firestore enabled

### Steps

1. Clone this repo:
   ```bash
   git clone https://github.com/Kishalay15/jarurat_whatsappClient
   
   cd whatsapp-chatbot-java
   ```

2. Place your Firebase key JSON in `src/main/resources/` (for local testing)

3. Start the app:
   ```bash
   mvn spring-boot:run
   ```

---

## 🌐 Deploying to Render

1. Push the code to a GitHub repository.
2. In Render:
    - Build command: `./mvnw clean install`
    - Start command: `java -jar target/whatsappClient-0.0.1-SNAPSHOT.jar`
3. Add the `FIREBASE_CONFIG` environment variable (paste JSON key as single-line string).

---

## 📬 Contact

For any queries, reach out via [kishalaylahiri@gmail.com].

[My portfolio](https://personal-portfolio-wheat-kappa.vercel.app/)

---

