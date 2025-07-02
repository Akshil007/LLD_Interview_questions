package Service.Impl;

import Models.Car;
import Models.CarStatus;
import Service.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchByType implements Search {
    @Override
    public List<Car> search(String S, Map<String, Car> map) {
        List<Car> list = new ArrayList<>();
        List<Car> all = new ArrayList<>(map.values());
        for(Car c: all){
            if(c.getCarStatus() == CarStatus.AVAILABLE && (S.equals("") || c.getCarType().name().equals(S))) {
                list.add(c);
            }
        }
        return list;
    }

}
