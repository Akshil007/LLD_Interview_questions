import Service.Impl.BookingManager;
import Service.Impl.InventoryManager;

public class CRS {
    static CRS crs;
    InventoryManager inventoryManager;
    BookingManager bookingManager;
    private CRS(){}

    private CRS(InventoryManager inventoryManager,  BookingManager bookingManager){
        this.inventoryManager = inventoryManager;
        this.bookingManager = bookingManager;
    }

    public static CRS getInstance(){
        if(crs == null){
            InventoryManager inventoryManager1 = new InventoryManager();
            BookingManager bookingManager1 = new BookingManager(inventoryManager1);
            crs = new CRS(inventoryManager1, bookingManager1);
        }
        return crs;
    }
}
