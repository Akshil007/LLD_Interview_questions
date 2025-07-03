package Example;

import Example.VendingStates.IdealState;
import Example.VendingStates.State;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.refill();

        State initalState = new IdealState();

        VendingMachine vendingMachine = new VendingMachine(initalState, inventory);
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                vendingMachine.displayInventory();
                System.out.println("Add amount:");
                int amount = sc.nextInt();
                State state = vendingMachine.getMachineState();
                state.insertCoin(vendingMachine, amount);

                state = vendingMachine.getMachineState();
                System.out.println("Selecting soda: ");
                int code = sc.nextInt();
                state.SelectItem(vendingMachine, code);

                state.SelectItem(vendingMachine, 101);

                state = vendingMachine.getMachineState();
                System.out.println("Dispensing items: ");
                state.dispenseItem(vendingMachine);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}