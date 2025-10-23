import Model.Expense;
import Model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Splitwise {
    private ExpenseManager expenseManager;
    private GroupManager groupManager;
    private Map<String, User> users;
    private static Splitwise instance;

    private Splitwise(){
        expenseManager = new ExpenseManager();
        users = new ConcurrentHashMap<>();
        groupManager = new GroupManager(expenseManager);
    }

    public static Splitwise getInstance(){
        if(instance == null) {
            synchronized (Splitwise.class){
                if(instance == null){
                    instance = new Splitwise();
                }
            }
        }
        return instance;
    }

    public User createUser(String name, String email){
        User user = new User(name, email);
        users.put(user.getUserId(), user);
        return user;
    }

    public Group createGroup(String name, List<User> users){
        return groupManager.createGroup(name, users);
    }

    public void createExpense(Expense.Builder builder){
        expenseManager.createExpense(builder);
    }

    public void settleUp(User from, User to, double amount){
        from.updateBalanceSheet(to, amount);
        to.updateBalanceSheet(from, -amount);
    }
}
