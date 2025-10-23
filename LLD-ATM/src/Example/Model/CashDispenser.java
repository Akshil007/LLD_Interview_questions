package Example.Model;

import Example.ChainOfResponsibility.Handle10;
import Example.ChainOfResponsibility.Handle100;
import Example.ChainOfResponsibility.Handle50;
import Example.ChainOfResponsibility.Handler;

public class CashDispenser {
    Handler handler;
    private static CashDispenser instance;
    public CashDispenser(){
        Handler handler100 = new Handle100();
        Handler handler50 = new Handle50();
        Handler handler10 = new Handle10();

        handler100.setNext(handler50);
        handler50.setNext(handler10);
        handler = handler100;
    }

    public static CashDispenser getInstance(){
        if(instance == null){
            synchronized (CashDispenser.class){
                if(instance == null){
                    instance = new CashDispenser();
                }
            }
        }
        return instance;
    }

    public void dispenseMoney(int amount){
        handler.handle(amount);
    }
}
