package Models;

public class Seat {
    int id;
    double price;
    private Status status;
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


    void changeStatus(Status newStatus){
        status = newStatus;
    }

    public boolean reserve() throws InterruptedException {
        synchronized (this) {
            if(status.equals(Status.AVAILABLE)) {
                Thread.sleep(1000);
                status = Status.RESERVED;
                return true;
            }
            return false;
        }
    }

    // verify payment status before changing to book status
    public boolean book(){
        if(status.equals(Status.RESERVED)){
            status = Status.BOOKED;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n\t\t\t Seat{" +
                "id=" + id +
                ", price=" + price +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
