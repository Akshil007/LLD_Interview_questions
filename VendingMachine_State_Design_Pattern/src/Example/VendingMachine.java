package Example;

import Example.VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State machineState;
    private Inventory inventory;
    private int total = 0;

    public State getMachineState() {
        return machineState;
    }

    public void setMachineState(State machineState) {
        this.machineState = machineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getDispensableItem() {
        return dispensableItem;
    }

    public void setDispensableItem(List<Item> dispensableItem) {
        this.dispensableItem = dispensableItem;
    }

    private List<Item> dispensableItem;

    public VendingMachine(State machineState, Inventory inventory) {
        this.machineState = machineState;
        this.inventory = inventory;
        this.total = 0;
        dispensableItem = new ArrayList<>();
    }

    public void addMoney(int amount){
        total += amount;
        System.out.println("Money got added !!");
        System.out.println("Total balance : " + total);
    }

    public void updateState(State state){
        System.out.println("Previous state: ");
        System.out.println(machineState.toString());
        machineState = state;
        System.out.println("Current state: ");
        System.out.println(machineState.toString());
    }

    public int refund() {
        System.out.println("Refund initiated of: " + total);
        total = 0;
        return total;
    }

    public void addToCart(int code) {
        Item item;
        try {
            item = inventory.takeItem(code);
        } catch (Exception e) {
            System.out.println("Out of stock !!");
            return;
        }
        if(total < item.getPrice()) {
            System.out.println("Not enough amount");
            inventory.addItem(item.getCode());
            return;
        }
        total -= item.getPrice();
        dispensableItem.add(item);

        System.out.println("Amount left: " + total);
    }

    public void dispenseItems(){
        for(Item item: dispensableItem){
            System.out.println("you got 1 ->" + item.getType());
        }
        dispensableItem.clear();
        if(total > 0)
            refund();
    }

    public void displayInventory() {
        inventory.display();
    }

    public void insertCoin(int amount) throws Exception {
        machineState.insertCoin(this, amount);
    }
    public void cancelProcess() throws Exception {
        machineState.cancelProcess(this);
    }
    public void SelectItem(int code) throws Exception {
        machineState.SelectItem(this, code);
    }
    public void dispenseItem() throws Exception {
        machineState.dispenseItem(this);
    }
}
