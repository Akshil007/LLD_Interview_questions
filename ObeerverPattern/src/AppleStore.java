import java.util.ArrayList;
import java.util.List;

public class AppleStore implements Store{

    int iphoneStock = 0;

    List<Customer> customerList;

    AppleStore(){
        customerList = new ArrayList<>();
    }

    @Override
    public void add(Customer c) {
        customerList.add(c);
    }

    @Override
    public void remove(Customer c) {
        customerList.remove(c);
    }

    @Override
    public void notifyC() {
        for(Customer c: customerList){
            c.update();
        }
    }

    public void updateStock(int addition) {
        iphoneStock += addition;
        notifyC();
    }
}
