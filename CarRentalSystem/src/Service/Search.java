package Service;

import Models.Car;

import java.util.List;
import java.util.Map;

public interface Search {
    public List<Car> search(String S, Map<String, Car> map);

}
