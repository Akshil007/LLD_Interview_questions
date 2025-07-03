package Example;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Item> itemMap;
    private Map<Item, Integer> inventory;

    public Inventory() {
        inventory = new HashMap<>();
        itemMap = new HashMap<>();
    }

    public void refill () {
        int code = 100;
        int price = 40;
        int size = 5;
        for (Soda soda : Soda.values()) {
            Item item1 = new Item(soda, code, price);
            itemMap.put(code , item1);
            inventory.put(item1, size);
            code++;
            price += 10;
        }
    }

    public Item takeItem (int code) throws Exception {
        if(!itemMap.containsKey(code))
            throw new Exception("Item doesn't Exist");
        Item item = itemMap.get(code);
        if(!inventory.containsKey(item) || inventory.get(item) <=0 )
            throw new Exception("Item out of stock");
        inventory.put(item, inventory.get(item) - 1);
        System.out.println("Item added into cart");
        return item;
    }

    public void addItem (int code) {
        Item item = itemMap.get(code);
        int quan = inventory.getOrDefault(item, 0 );
        quan++;
        inventory.put(item, quan);
        System.out.println("Item added into inventory");
    }

    public void display(){
        for(Map.Entry<Item, Integer> map: inventory.entrySet()) {
            Item item = map.getKey();
            System.out.println(item.getType() + " " + item.getCode() + " " + item.getPrice());
        }
    }


}
