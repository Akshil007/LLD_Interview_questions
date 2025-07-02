package Service.Impl;

import Models.Booking;
import Models.Car;
import Models.CarStatus;
import Models.User;

import java.util.*;

public class BookingManager {
    Map<String,List<Booking>> bookingList;
    InventoryManager inventoryManager;
    private static int currentBookingId = 0;

    public BookingManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        bookingList = new HashMap<>();
    }

    // No 2 users should able to book one car
    /*
    Here concurrent hashmap will not work, because it allows multiple thread to read simultenously, which will not work in our case.
    * */
     synchronized public void createBooking(User u, String numberPlate, long startTime, long endTime) {
        try {
            Map<String, Car> inventory = inventoryManager.getInventory();
            if (inventory.containsKey(numberPlate) && inventory.get(numberPlate).getCarStatus() == CarStatus.AVAILABLE) {
                Thread.sleep(1000);
                Car c = inventory.get(numberPlate);
                Booking booking = new Booking(startTime, endTime, c, currentBookingId);
                currentBookingId++;
                c.setCarStatus(CarStatus.BOOOKED);

                bookingList.computeIfAbsent(u.getName(), k -> new ArrayList<>()).add(booking);
                System.out.println("Booking made successfully");

            } else {
                System.out.println("Invalid Number plate");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteBooking(int bookingId, User u){
        List<Booking> l = bookingList.getOrDefault(u.getName(), null);
        if(l != null){
            Booking foundBooking = l.stream()
                    .filter(booking -> booking.getBookingId() == bookingId)
                    .findFirst()
                    .orElse(null); // Returns null if not found
            if(foundBooking != null){
                foundBooking.getCar().setCarStatus(CarStatus.AVAILABLE);
                l.remove(foundBooking);
                return;
            }
        }
        System.out.println("There is no such booking");
    }

    public void listAllBooking(){
        System.out.println("==========ALL BOOKING========");
        for(Map.Entry<String,List<Booking>> e: bookingList.entrySet()){
            System.out.println("Bookings for user : " + e.getKey());
            e.getValue().stream().forEach(System.out::println);
        }
    }


}
