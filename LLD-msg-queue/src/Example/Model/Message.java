package Example.Model;

import java.util.UUID;

public class Message {
    String id;
    String payload;

    public Message(String payload) {
        id = UUID.randomUUID().toString();
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void printMessage(){
        System.out.println("Msg: " + payload);
    }
}
