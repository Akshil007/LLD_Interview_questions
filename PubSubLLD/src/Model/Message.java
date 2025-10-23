package Model;

import java.time.Instant;

public class Message {
    String payload;
    Instant timestamp;

    public Message(String msg){
        payload = msg;
        timestamp = Instant.now();
    }

    public String getPayload() {
        return payload;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "payload='" + payload + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
