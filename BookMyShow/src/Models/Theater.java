package Models;

import java.util.List;

public class Theater {
    List<Show> showList;
    String address;
    City city;

    public Theater(List<Show> showList, City city, String address) {
        this.showList = showList;
        this.city = city;
        this.address = address;
    }

    public Show getShow(int id){
        for(Show show: showList){
            if(show.showId == id)
                return show;
        }
        return null;
    }

    @Override
    public String toString() {
        return "\n \t Theater{" +
                "showList=" + showList +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }
}
