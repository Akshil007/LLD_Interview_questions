package Service.Impl;

import Models.Car;
import Service.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryManager {
    private Map<String, Car> inventory;
    private Search searchStrategy;

    public InventoryManager(Search s){
        inventory = new HashMap<>();
        searchStrategy = s;
    }

    public InventoryManager() {
        inventory = new ConcurrentHashMap<>();
        searchStrategy = new SearchByType();
    }

    public void addCar(Car c){
        if(!inventory.containsKey(c.getNumberPlate())){
            inventory.put(c.getNumberPlate(),c);
            System.out.println("Car Added");
        } else {
            System.out.println("Car was already added");
        }

    }

    public boolean bookCar(Car c){
        return true;
    }

    public void searchCar(String key){
        List<Car> carsList = searchStrategy.search(key, inventory);
        System.out.println("List of Cars:");
        for(Car c: carsList){
            System.out.println(c.toString());
        }
    }

    public void setSearchStrategy(Search searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public Map<String, Car> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Car> inventory) {
        this.inventory = inventory;
    }

    public Search getSearchStrategy() {
        return searchStrategy;
    }
}
