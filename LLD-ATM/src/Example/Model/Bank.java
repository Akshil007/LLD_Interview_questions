package Example.Model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    Map<String, Account> cardToAccount;

    public Bank(){
        cardToAccount = new HashMap<>();
    }

    public boolean validateCardId(String cardId){
        if(cardToAccount.containsKey(cardId)){
            return true;
        }
        throw new IllegalArgumentException("Invalid cardId");
    }

    public Account getAccount(Card card){
        if(cardToAccount.containsKey(card.getCardId())){
            return cardToAccount.get(card.getCardId());
        }
        throw new IllegalArgumentException("Invalid card");
    }

    public Card createAccount(User user, int initMoney){
        Card card = new Card("1234");
        Account newAccount = new Account(user, initMoney, card);
        cardToAccount.put(card.getCardId(), newAccount);
        return card;
    }
}
