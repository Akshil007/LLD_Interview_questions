package Example.Model;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    long timestamp;
    String id;
    Action action;
    int amount;
    public Transaction(Action action1, int amount1){
        timestamp = Instant.now().toEpochMilli();
        id = UUID.randomUUID().toString();
        action = action1;
        amount = amount1;
    }
}
