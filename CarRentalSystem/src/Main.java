import Models.Car;
import Models.CarType;
import Models.User;
import Service.Impl.BookingManager;
import Service.Impl.InventoryManager;

import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CRS crs = CRS.getInstance();

        InventoryManager inventoryManager =  crs.inventoryManager;
        inventoryManager.addCar(new Car(1000, "suv1", CarType.SUV));
        inventoryManager.addCar(new Car(800, "sedan1", CarType.SEDAN));
        inventoryManager.addCar(new Car(500, "hatchback1", CarType.HATCHBACK));

        inventoryManager.searchCar("");

        inventoryManager.searchCar("SUV");

        BookingManager bookingManager = crs.bookingManager;



        Thread t = new Thread(() -> {
            bookingManager.createBooking(new User("user1"), "suv1", System.currentTimeMillis(), System.currentTimeMillis() + (24 * 60 * 60 * 1000));
            bookingManager.listAllBooking();
        });
        t.start();

        bookingManager.createBooking(new User("user2"), "suv1", System.currentTimeMillis(), System.currentTimeMillis() + (24 * 60 * 60 * 1000));

//        inventoryManager.searchCar("");

        bookingManager.listAllBooking();



    }
}