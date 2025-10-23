import Model.Expense;
import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Group {
    String id;
    String name;
    Map<String, User> members;
    List<Expense> expenseList;
    ExpenseManager expenseManager;

    public Group(String name, Map<String, User> members, ExpenseManager expenseManager) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.members = members;
        expenseList = new ArrayList<>();
        this.expenseManager = expenseManager;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User member) {
        members.put(member.getUserId(), member);
    }

    public String getId() {
        return id;
    }

    public void createExpense(Expense.Builder builder){
        Expense expense = expenseManager.createExpense(builder);

        validateExpense(expense);

        expense.setGroupId(this.id);
        expenseList.add(expense);
    }
    private void validateExpense(Expense expense){
        List<User> users = expense.getParticipants();

        for(User user1: users){
            if(!members.containsKey(user1.getUserId()))
                throw new RuntimeException("Involves members outside of group");
        }
    }
}
