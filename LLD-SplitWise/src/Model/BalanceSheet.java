package Model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    User owner;
    Map<User, Double> balanceMap;
    public BalanceSheet(User user){
        owner = user;
        balanceMap = new ConcurrentHashMap<>();
    }

    synchronized public void update(User user, double amount){
        if(user.equals(owner)){
            return;
        }
        balanceMap.compute(user, (k,v) -> v == null ? amount : v + amount);
        if(balanceMap.get(user) == 0){
            balanceMap.remove(user);
        }
    }

    public void print(){
        System.out.println(owner.name +" balance sheet: ");
        for(Map.Entry<User, Double> e: balanceMap.entrySet()){
            User user = e.getKey();
            double amount = e.getValue();

            if(amount > 0){
                System.out.println(user.name + " owes amount " + amount + " to you");
            } else {
                System.out.println("you owes amount " + (-amount) + " to " + user.name);
            }
        }
    }
}
