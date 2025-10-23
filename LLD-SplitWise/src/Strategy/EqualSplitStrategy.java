package Strategy;

import Model.Split;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calSplits(double amount, List<User> users, User paidBy, List<Double> splitValues) {
        throw new RuntimeException("Unsupported operation");
    }

    @Override
    public List<Split> calSplits(double amount, List<User> users, User paidBy) {
        List<Split> splitList = new ArrayList<>();
        double share = amount / users.size();
        for(User user: users){
            splitList.add(new Split(user, share));
        }
        return splitList;
    }
}
