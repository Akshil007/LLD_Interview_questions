package Example.State;

import Example.ATM;
import Example.Model.Account;
import Example.Model.Action;
import Example.Model.Bank;
import Example.Model.Card;

public class WidthrawState implements State{
    @Override
    public void cardInsert(ATM atm, Card card) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void amountInsert(ATM atm, int amount) {
        Card card = atm.getCurrentInsertedCard();
        Bank bank = atm.getBank();
        Account account = bank.getAccount(card);
        try {
            account.updateBalance(amount, Action.WIDTHRAW);
            atm.getCashDispenser().dispenseMoney(amount);
            atm.removeCard();
            atm.setMachineState(new IdealState());
        } catch (IllegalArgumentException e){
            System.out.println("operation unsuccessful");
        }
    }

    @Override
    public void pinInsert(ATM atm, String pin) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void cancelTransaction(ATM atm) {
        atm.removeCard();
        atm.setMachineState(new IdealState());
    }
}
