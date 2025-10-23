import Model.Expense;
import Model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupManager {
    Map<String, Group> groupList;
    ExpenseManager expenseManager;

    public GroupManager(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
        groupList = new HashMap<>();
    }

    public Group createGroup(String name, List<User> users) {
        Map<String, User> userMap = users.stream().collect(Collectors.toMap(User::getUserId, user -> user));
        Group group = new Group(name, userMap, expenseManager);
        groupList.put(group.getId(), group);
        return group;
    }
}
