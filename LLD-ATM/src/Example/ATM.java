package Example;

import Example.Model.Bank;
import Example.Model.Card;
import Example.Model.CashDispenser;
import Example.State.IdealState;
import Example.State.State;

public class ATM {
    State machineState;
    Bank bank;
    Card currentInsertedCard;
    CashDispenser cashDispenser;

    public ATM(Bank bank1){
        machineState = new IdealState();
        bank = bank1;
        cashDispenser = CashDispenser.getInstance();
    }

    public State getMachineState() {
        return machineState;
    }

    public void setMachineState(State machineState) {
        System.out.println("prev state:"+ machineState.toString());
        this.machineState = machineState;
        System.out.println("updated state:"+ machineState.toString());
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void removeCard(){
        currentInsertedCard = null;
    }

    public Card getCurrentInsertedCard() {
        return currentInsertedCard;
    }

    public void setCard(Card newCard) {
        this.currentInsertedCard = newCard;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void cardInsert(Card card){
        machineState.cardInsert(this, card);
    }

    public void amountInsert(int amount){
        machineState.amountInsert(this, amount);
    }
    public void pinInsert(String pin){
        machineState.pinInsert(this, pin);
    }
    public void cancelTransaction(){
        machineState.cancelTransaction(this);
    }
}
