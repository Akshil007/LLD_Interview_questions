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
                vendingMachine.insertCoin(amount);

                System.out.println("Selecting soda: ");
                int code = sc.nextInt();
                vendingMachine.SelectItem(code);

                vendingMachine.SelectItem(101);

                System.out.println("Dispensing items: ");
                vendingMachine.dispenseItem();

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}