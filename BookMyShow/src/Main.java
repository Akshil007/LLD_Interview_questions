//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BMS bms = BMS.getInstance();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bms.start();
            }
        }, "user1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bms.start();
            }
        }, "user2");

        thread1.start();
        thread2.start();
    }
}