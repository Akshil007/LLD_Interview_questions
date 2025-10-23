import Example.ATM;
import Example.Model.Bank;
import Example.Model.Card;
import Example.Model.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);

        User user = new User();

        Card card = bank.createAccount(user, 1000);

        atm.cardInsert(card);

        atm.pinInsert(card.getPin());

        atm.amountInsert(172);


    }
}