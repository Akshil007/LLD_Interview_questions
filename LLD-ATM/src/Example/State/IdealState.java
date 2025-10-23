package Example.State;

import Example.ATM;
import Example.Model.Card;

public class IdealState implements State {


    @Override
    public void cardInsert(ATM atm, Card card) {
        if(atm.getBank().validateCardId(card.getCardId())){
            atm.setCard(card);
            State nextState = new AuthenticationState();
            atm.setMachineState(nextState);
            return;
        }
        throw new IllegalArgumentException("Invalid card");
    }

    @Override
    public void amountInsert(ATM atm, int amount) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void pinInsert(ATM atm, String pin) {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public void cancelTransaction(ATM atm) {
        throw new IllegalArgumentException("Invalid operation");
    }
}
