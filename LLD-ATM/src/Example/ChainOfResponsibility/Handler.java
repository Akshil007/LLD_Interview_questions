package Example.ChainOfResponsibility;

public interface Handler {
    void handle(int amount);
    void setNext(Handler handler);
}
