public class ParkingSpot {
    int id;
    boolean isFree;
    Vehicle vehicle;
    int price;
    ParkingSpot(int id, int price){
        this.id = id;
        isFree = true;
        this.price = price;
    }
    void parkVehicle(Vehicle v){
        if(vehicle != null)
            throw new RuntimeException("Vehicle already Parked");
        vehicle = v;
        isFree = false;
    }
}
