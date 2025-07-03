package Example.VendingStates;


import Example.Item;
import Example.VendingMachine;

public interface State {
    void insertCoin(VendingMachine vm, int amount) throws Exception;
    void cancelProcess(VendingMachine vm) throws Exception;
    void SelectItem(VendingMachine vm, int code) throws Exception;
    void dispenseItem(VendingMachine vm) throws Exception;
}
