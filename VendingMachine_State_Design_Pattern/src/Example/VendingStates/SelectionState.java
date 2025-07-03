package Example.VendingStates;

import Example.Item;
import Example.VendingMachine;

public class SelectionState implements State {

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
        vm.addToCart(code);
    }

    @Override
    public void dispenseItem(VendingMachine vm) throws Exception {
        vm.updateState(new DispenseState());
        DispenseState dispenseState = new DispenseState(vm);
    }
}
