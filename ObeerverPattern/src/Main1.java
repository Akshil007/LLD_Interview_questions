//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {
    public static void main(String[] args) {
        AppleStore appleStore = new AppleStore();
        AppleCustomer c1 = new AppleCustomer("c1");
        appleStore.add(c1);
        appleStore.updateStock(10);
        AppleCustomer c2 = new AppleCustomer("c2");
        appleStore.add(c2);
        appleStore.updateStock(20);
        appleStore.remove(c2);
        appleStore.updateStock(30);
    }
}