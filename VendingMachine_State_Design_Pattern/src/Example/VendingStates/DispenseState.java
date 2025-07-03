package Example.VendingStates;

import Example.Item;
import Example.VendingMachine;

public class DispenseState implements State {

    DispenseState(){

    }

    DispenseState(VendingMachine vendingMachine) throws Exception {
        dispenseItem(vendingMachine);
    }
    @Override
    public void insertCoin(VendingMachine vm, int amount) throws Exception {
        throw new Exception("Un supported operation");
    }

    @Override
    public void cancelProcess(VendingMachine vm) throws Exception {
        throw new Exception("Un supported operation");
    }

    @Override
    public void SelectItem(VendingMachine vm, int code) throws Exception {
        throw new Exception("Un supported operation");
    }

    @Override
    public void dispenseItem(VendingMachine vm) throws Exception {
        vm.dispenseItems();
        vm.updateState(new IdealState());
    }
}
