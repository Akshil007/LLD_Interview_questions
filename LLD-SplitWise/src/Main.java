import Model.Expense;
import Model.SplitType;
import Model.User;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Splitwise splitwise = Splitwise.getInstance();

        User user1 = splitwise.createUser("user1", "u1@gmail.com");
        User user2 = splitwise.createUser("user2", "u2@gmail.com");
        User user3 = splitwise.createUser("user3", "u3@gmail.com");

        Group group = splitwise.createGroup("Goa", Arrays.asList(user1, user2, user3));


        splitwise.createExpense(new Expense.Builder().setDescription("goa food")
                .setAmount(200)
                .setPaidBy(user3)
                .setParticipants(Arrays.asList(user1, user2))
                .setSplitType(SplitType.EQUAL));

        group.createExpense(new Expense.Builder().setDescription("goa trip")
                .setAmount(150)
                .setPaidBy(user1)
                .setParticipants(Arrays.asList(user1, user2, user3))
                .setSplitType(SplitType.EQUAL));

        user1.getBalanceSheet().print();
        user2.getBalanceSheet().print();
        user3.getBalanceSheet().print();

        splitwise.settleUp(user2, user1, 50);
        splitwise.settleUp(user2, user3, 70);

        user1.getBalanceSheet().print();
        user2.getBalanceSheet().print();
        user3.getBalanceSheet().print();


    }
}