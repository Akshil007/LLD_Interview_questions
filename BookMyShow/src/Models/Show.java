package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Show {
    int showId;
    int screenId;
    Movie movie;
    String startTime;
    List<Seat> seatList;

    public Show(int showId, int screenId, Movie movie, String startTime, List<Seat> seatList) {
        this.showId = showId;
        this.screenId = screenId;
        this.movie = movie;
        this.startTime = startTime;
        this.seatList = seatList;
    }

    void addSeat(Seat s){
        seatList.add(s);
    }

    void printSeatMap(){
        System.out.println("Available seats: ");
        for(Seat s: seatList){
            if(s.getStatus().equals(Status.AVAILABLE)) {
                System.out.println(s.toString());
            }
        }
    }

    public List<Seat> getSeat(Set<Integer> ids){
        List<Seat> returnList = new ArrayList<>();
        for(Seat s: seatList){
            if(ids.contains(s.id) && s.getStatus().equals(Status.AVAILABLE)){
                returnList.add(s);
            }
        }
        return returnList;
    }

    @Override
    public String toString() {
        return "\n \t\tShow{" +
                "showId=" + showId +
                ", screenId=" + screenId +
                ", movie=" + movie +
                ", startTime='" + startTime + '\'' +
                ", seatList=" + seatList +
                '}';
    }
}
