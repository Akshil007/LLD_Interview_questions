import java.util.List;

public class Floor {
    List<ParkingSpot> parkingSpotList;
    int floor;

    public Floor(List<ParkingSpot> parkingSpotList, int floor) {
        this.parkingSpotList = parkingSpotList;
        this.floor = floor;
    }

    void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotList.add(parkingSpot);
    }

    // remove
    // update

}
