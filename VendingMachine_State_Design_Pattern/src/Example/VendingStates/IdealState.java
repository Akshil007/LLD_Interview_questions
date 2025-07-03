package Example.VendingStates;

import Example.Item;
import Example.VendingMachine;

public class IdealState implements State{

    @Override
    public void insertCoin(VendingMachine vm, int amount) {
        State moneyState = new MoneyAcceptingState();
        vm.updateState(moneyState);
        vm.addMoney(amount);
    }

    @Override
    public void cancelProcess(VendingMachine vm) throws Exception {
        throw new Exception("un supported operation at this stage");
    }

    @Override
    public void SelectItem(VendingMachine vm, int code) throws Exception {
        throw new Exception("un supported operation at this stage");
    }

    @Override
    public void dispenseItem(VendingMachine vm) throws Exception {
        throw new Exception("un supported operation at this stage");
    }
}
