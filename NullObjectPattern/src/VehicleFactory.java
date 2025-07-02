public class VehicleFactory {
    Vehicle v;
    private VehicleFactory(){}

    public static Vehicle getVehicle(String type){
        if(type.equals("car")){
            return new Car();
        }
        return new NullObject();
    }
}
