package Example.Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class Account {
    String accountId;
    int balance;
    User user;
    Card card;
    Deque<Transaction> transactions;

    public Account(User user, int initialBalance, Card card){
        accountId = UUID.randomUUID().toString();
        this.user = user;
        balance = initialBalance;
        this.card = card;
        transactions = new ArrayDeque<>();
    }

    public void checkBalance(){
        System.out.println("Current Balance: " + balance);
    }

    public synchronized void updateBalance(int amount, Action action){
        if(action.equals(Action.WIDTHRAW)){
            if(amount > balance)
                throw new IllegalArgumentException("Not enough balance");
            balance -= amount;
        } else {
            balance += amount;
        }
        transactions.offer(new Transaction(action, amount));
    }

    public boolean validatePin(String pin){
        if(card.getPin().equals(pin))
            return true;
        throw new IllegalArgumentException("Worng pin");
    }



}
