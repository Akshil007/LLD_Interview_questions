package Example.ChainOfResponsibility;

public class BaseHandler implements Handler{
    Handler nextHandler;
    int currCurrency;

    BaseHandler(int currCurrency){
        this.currCurrency = currCurrency;
    }

    @Override
    public void handle(int amount) {
        while (amount >= currCurrency){
            System.out.println("Dispence: "+ currCurrency);
            amount -= currCurrency;
        }
        if(nextHandler != null){
            nextHandler.handle(amount);
        } else {
            System.out.println("can't handle request of " + amount);
        }
    }

    @Override
    public void setNext(Handler handler) {
        nextHandler = handler;
    }
}
