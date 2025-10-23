package Model;

import java.util.UUID;

public class User {
    String userId;
    String name;
    String email;
    BalanceSheet balanceSheet;

    public User(String name, String email) {
        userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        balanceSheet = new BalanceSheet(this);
    }

    public void updateBalanceSheet(User user, double amount){
        balanceSheet.update(user, amount);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public String getUserId() {
        return userId;
    }
}
