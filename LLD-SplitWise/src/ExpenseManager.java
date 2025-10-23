import Model.Expense;
import Model.Split;
import Model.SplitType;
import Model.User;
import Strategy.SplitFactory;
import Strategy.SplitStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExpenseManager {
    Map<String, Expense> expenseMap;

    public ExpenseManager() {
        expenseMap = new ConcurrentHashMap<>();
    }

    public Expense createExpense(Expense.Builder builder){
        Expense expense = builder.build();

        if(expense.getSplitType() == null)
            throw new IllegalArgumentException("SplitType not given");


        SplitStrategy splitStrategy = SplitFactory.getSplitStrategy(expense.getSplitType());

        if(expense.getSplitType().equals(SplitType.EQUAL)) {
            expense.setSplits(splitStrategy.calSplits(expense.getAmount(), expense.getParticipants(), expense.getPaidBy()));
        }
        updateBalanceSheet(expense.getSplits(), expense.getPaidBy());

        expenseMap.put(expense.getId(), expense);
        return expense;
    }

    private void updateBalanceSheet(List<Split> splits, User paidBy){
        for(Split split: splits){
            User user = split.getUser();
            double amount = split.getAmount();
            paidBy.updateBalanceSheet(user, amount);
            user.updateBalanceSheet(paidBy, -1*amount);
        }
    }
}
