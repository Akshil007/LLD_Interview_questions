import Models.City;
import Models.Theater;

import java.util.List;
import java.util.Map;

public class TheaterController {
    Map<City, List<Theater>> cityTheaterMap;

    public TheaterController(Map<City, List<Theater>> cityTheaterMap) {
        this.cityTheaterMap = cityTheaterMap;
    }

//    Theater getTheater(){
//        cityTheaterMap.get()
//    }

    @Override
    public String toString() {
        return "TheaterController{" +
                "cityTheaterMap=" + cityTheaterMap +
                '}';
    }
}
