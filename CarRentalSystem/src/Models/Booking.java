package Models;

public class Booking {

    private long startTime;
    private long endTime;
    private Car car;
    private int bookingId;


    public Booking(long startTime, long endTime, Car car, int bookingId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.car = car;
        this.bookingId = bookingId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", car=" + car +
                ", bookingId=" + bookingId +
                '}';
    }
}
