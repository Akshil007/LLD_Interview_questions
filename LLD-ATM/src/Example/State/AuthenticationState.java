package Example.State;

import Example.ATM;
import Example.Model.Account;
import Example.Model.Bank;
import Example.Model.Card;

public class AuthenticationState implements State{
    @Override
    public void cardInsert(ATM atm, Card card) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void amountInsert(ATM atm, int amount) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void pinInsert(ATM atm, String pin) {
        Card card = atm.getCurrentInsertedCard();
        Bank bank = atm.getBank();
        Account account = bank.getAccount(card);
        try {
            if(account.validatePin(pin)){
                atm.setMachineState(new WidthrawState());
            }
        } catch (IllegalArgumentException e){
            System.out.println("Wrong pin inserted, please try again");
        }
    }

    @Override
    public void cancelTransaction(ATM atm) {
        atm.removeCard();
        atm.setMachineState(new IdealState());
    }
}
