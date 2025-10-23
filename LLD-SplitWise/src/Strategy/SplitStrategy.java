package Strategy;

import Model.Split;
import Model.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    List<Split> calSplits(double amount, List<User> users, User paidBy, List<Double> splitValues);
    List<Split> calSplits(double amount, List<User> users, User paidBy);
}
