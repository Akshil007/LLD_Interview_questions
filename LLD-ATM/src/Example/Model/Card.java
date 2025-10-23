package Example.Model;

import java.util.UUID;

public class Card {
    String cardId;
    String pin;

    public Card(String pin) {
        this.cardId = UUID.randomUUID().toString();
        this.pin = pin;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
