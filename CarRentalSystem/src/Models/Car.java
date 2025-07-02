package Models;

public class Car {
    private int cost;
    private String numberPlate;
    private CarStatus carStatus;
    private CarType carType;

    public Car(int cost, String numberPlate, CarType carType) {
        this.cost = cost;
        this.numberPlate = numberPlate;
        this.carStatus = CarStatus.AVAILABLE;
        this.carType = carType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getCost() {
        return cost;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public CarType getCarType() {
        return carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cost=" + cost +
                ", carType=" + carType +
                ", numberPlate='" + numberPlate + '\'' +
                ", carStatus=" + carStatus +
                '}';
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
