package Example.VendingStates;

import Example.Item;
import Example.VendingMachine;

public class MoneyAcceptingState implements State {
    @Override
    public void insertCoin(VendingMachine vm, int amount) throws Exception {
        vm.addMoney(amount);
    }

    @Override
    public void cancelProcess(VendingMachine vm) throws Exception {
        vm.refund();
        vm.updateState(new IdealState());
    }

    @Override
    public void SelectItem(VendingMachine vm, int code) throws Exception {
        vm.updateState(new SelectionState());
        vm.addToCart(code);
    }

    @Override
    public void dispenseItem(VendingMachine vm) throws Exception {
        throw new Exception("Un supported operation");
    }
}
