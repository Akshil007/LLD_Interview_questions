package Example.State;

import Example.Model.Card;
import Example.ATM;

public interface State {
    void cardInsert(ATM atm,Card card);
    void amountInsert(ATM atm,int amount);
    void pinInsert(ATM atm,String pin);
    void cancelTransaction(ATM atm);
}
