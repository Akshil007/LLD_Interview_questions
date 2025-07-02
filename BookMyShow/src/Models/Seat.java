package Models;

public class Seat {
    int id;
    double price;
    Status status;
    Type type;

    public Seat(int id, double price, Type type, Status status) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    void changeStatus(Status newStatus){
        status = newStatus;
    }
}
